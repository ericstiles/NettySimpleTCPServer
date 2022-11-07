package com.ets.learn.netty;

import com.ets.learn.netty.handler.HandlerFactory;
import com.ets.learn.netty.thread.action.factory.AbstractActionsFactory;
import com.ets.learn.netty.thread.state.State;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class SimpleTCPChannelInitializer extends ChannelInitializer<SocketChannel> {

    private final State state;
    private final AbstractActionsFactory abstractActionsFactory;
    HandlerFactory handlerFactory;

    public SimpleTCPChannelInitializer(HandlerFactory handlerFactory, State state, AbstractActionsFactory abstractActionsFactory){
        this.handlerFactory = handlerFactory;
        this.state = state;
        this.abstractActionsFactory = abstractActionsFactory;
    }

    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline().addLast(new StringEncoder());
        socketChannel.pipeline().addLast(new StringDecoder());
        socketChannel.pipeline().addLast(handlerFactory.providesSimpleTCPChannelHandler(state, abstractActionsFactory));
    }
}
