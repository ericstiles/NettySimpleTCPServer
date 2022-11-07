package com.ets.learn.netty.thread.action;

import com.ets.learn.netty.thread.state.State;
import io.netty.channel.ChannelHandlerContext;

public interface ActionFactory<ActionName, T extends Action> {

    T create(ChannelHandlerContext ctx, State state, String s);

    ActionName getActionName();

}
