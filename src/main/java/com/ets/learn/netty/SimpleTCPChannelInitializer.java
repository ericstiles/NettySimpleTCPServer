package com.ets.learn.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class SimpleTCPChannelInitializer extends ChannelInitializer<SocketChannel> {

    SimpleChannelInboundHandler simpleChannelInboundHandler;

    public SimpleTCPChannelInitializer(SimpleChannelInboundHandler simpleChannelInboundHandler){
        this.simpleChannelInboundHandler = simpleChannelInboundHandler;
    }

    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline().addLast(new StringEncoder());
        socketChannel.pipeline().addLast(new StringDecoder());
        socketChannel.pipeline().addLast(simpleChannelInboundHandler);
    }
}
