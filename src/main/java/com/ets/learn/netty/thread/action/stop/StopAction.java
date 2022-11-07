package com.ets.learn.netty.thread.action.stop;

import com.ets.learn.netty.thread.action.Action;
import com.ets.learn.netty.thread.action.ActionName;
import com.ets.learn.netty.thread.state.State;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor(staticName = "of")
public class StopAction implements Action {

    @NonNull
    @Getter
    ActionName actionName;
    @NonNull
    ChannelHandlerContext channelHandlerContext;
    @NonNull
    State state;
    @NonNull
    String message;

    @Override
    public void run() {
        LOGGER.debug("State before checking: {}", state);
        boolean cancel = "cancel".equals(message);
        state.setCancelTransaction(cancel);
        ReferenceCountUtil.release(message);
        LOGGER.debug("State after checking: {}", state);
    }
}

