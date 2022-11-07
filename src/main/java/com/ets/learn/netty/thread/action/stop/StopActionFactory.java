package com.ets.learn.netty.thread.action.stop;

import com.ets.learn.netty.thread.action.ActionFactory;
import com.ets.learn.netty.thread.action.ActionName;
import com.ets.learn.netty.thread.action.message.MessageAction;
import com.ets.learn.netty.thread.action.stop.StopAction;
import com.ets.learn.netty.thread.state.State;
import io.netty.channel.ChannelHandlerContext;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
public class StopActionFactory implements ActionFactory<ActionName, StopAction> {

    @NonNull
    @Getter
    ActionName actionName;

    @Override
    public StopAction create(ChannelHandlerContext ctx, State state, String s) {
        return StopAction.of(actionName, ctx, state, s);
    }

}