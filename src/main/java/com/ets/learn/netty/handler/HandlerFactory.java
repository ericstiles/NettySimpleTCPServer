package com.ets.learn.netty.handler;

import com.ets.learn.netty.thread.action.factory.AbstractActionFactory;
import com.ets.learn.netty.thread.state.State;
import io.netty.channel.ChannelInboundHandler;

import javax.inject.Inject;

public class HandlerFactory {

    @Inject
    public HandlerFactory(){}

    public ChannelInboundHandler providesSimpleTCPChannelHandler(State state, AbstractActionFactory abstractActionF){
        return new SimpleTCPChannelHandler(state, abstractActionF);
    }

}
