package com.ets.learn.netty.thread.action.message;

import com.ets.learn.netty.thread.action.ActionFactory;
import com.ets.learn.netty.thread.action.ActionName;
import com.ets.learn.netty.thread.action.message.MessageAction;
import com.ets.learn.netty.thread.state.State;
import io.netty.channel.ChannelHandlerContext;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
public class MessageActionFactory implements ActionFactory<ActionName, MessageAction> {

    @NonNull
    @Getter
    ActionName actionName;

    @Override
    public MessageAction create(ChannelHandlerContext ctx, State state, String s) {
        return MessageAction.create(actionName, ctx, state, s);
    }

}
