package com.ets.learn.netty.handler;

import io.netty.channel.ChannelInboundHandler;

import javax.inject.Inject;

public class HandlerFactory {

    @Inject
    public HandlerFactory(){}

    public ChannelInboundHandler providesSimpleTCPChannelHandler(){
        return new SimpleTCPChannelHandler();
    }

}
