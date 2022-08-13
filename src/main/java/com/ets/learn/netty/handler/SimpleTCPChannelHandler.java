package com.ets.learn.netty.handler;

import com.ets.learn.netty.Utils;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import javax.inject.Inject;

public class SimpleTCPChannelHandler extends SimpleChannelInboundHandler<String> {

    private static int counter = 0;

    private int id;

    @Inject
    public SimpleTCPChannelHandler(){
        id = counter;
        counter++;
    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        Utils.log(ctx.channel().remoteAddress(), "Channel Active");
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, String s) throws Exception {
        Utils.log(id, ctx.channel().remoteAddress(), s);
        ctx.channel().writeAndFlush("Thanks\n");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        Utils.log(ctx.channel().remoteAddress(), "Channel Inactive");
    }
}
