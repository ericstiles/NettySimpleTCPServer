package com.ets.learn.netty;

import com.ets.learn.netty.handler.HandlerFactory;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class SimpleTCPChannelInitializer extends ChannelInitializer<SocketChannel> {

    HandlerFactory handlerFactory;

    public SimpleTCPChannelInitializer(HandlerFactory handlerFactory){
        this.handlerFactory = handlerFactory;
    }

    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline().addLast(new StringEncoder());
        socketChannel.pipeline().addLast(new StringDecoder());
        socketChannel.pipeline().addLast(handlerFactory.providesSimpleTCPChannelHandler());
    }
}
