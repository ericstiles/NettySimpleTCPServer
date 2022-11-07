package com.ets.learn.netty.thread.action.message;

import com.ets.learn.netty.thread.action.Action;
import com.ets.learn.netty.thread.action.ActionName;
import com.ets.learn.netty.thread.state.State;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
//@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageAction implements Action<ActionName> {

    @NonNull
    ActionName actionName;
    @NonNull
    ChannelHandlerContext channelHandlerContext;
    @NonNull
    State state;
    @NonNull
    String message;

    public MessageAction(ActionName actionName, ChannelHandlerContext channelHandlerContext, State state, String message) {
        this.actionName=actionName;
        this.channelHandlerContext=channelHandlerContext;
        this.state=state;
        this.message=message;

    }

    public ActionName getActionName(){
        return actionName;
    }

    @Override
    public void run() {
        try {
            LOGGER.debug("Sleeping 5 seconds");
            Thread.sleep(5000);
            if (! state.isCancelTransaction()) {
                LOGGER.debug("message not cancelled, ship it!");
                channelHandlerContext.pipeline().writeAndFlush(message + "\n");
            } else {
                LOGGER.debug("message cancelled, scuttling!");
            }
            state.setCancelTransaction(false);
            ReferenceCountUtil.release(message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static MessageAction create(ActionName actionName, ChannelHandlerContext channelHandlerContext, State state, String message){
        return new MessageAction(actionName, channelHandlerContext, state, message);

    }

}

