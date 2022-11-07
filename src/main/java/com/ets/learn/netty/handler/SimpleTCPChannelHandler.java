package com.ets.learn.netty.handler;

import com.ets.learn.netty.Utils;
import com.ets.learn.netty.thread.action.factory.AbstractActionFactory;
import com.ets.learn.netty.thread.action.ActionName;
import com.ets.learn.netty.thread.state.State;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import java.util.concurrent.Executors;

@Slf4j
public class SimpleTCPChannelHandler extends SimpleChannelInboundHandler<String> {

    private static int counter = 0;
    private final State state;
    private final AbstractActionFactory abstractActionFactory;

    private int id;

    @Inject
    public SimpleTCPChannelHandler(State state, AbstractActionFactory abstractActionFactory){
        id = counter;
        counter++;
        this.state = state;
        this.abstractActionFactory = abstractActionFactory;
    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        Utils.log(ctx.channel().remoteAddress(), "Channel Active");
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, String s) throws Exception {
        LOGGER.debug("entering channel handler");
        Utils.log(id, ctx.channel().remoteAddress(), s);
        s = s.replaceAll("[\n\t]", "");
        String actionName = s.indexOf(" ") == -1 ? s : s.substring(0, s.indexOf(" "));
        Executors.newSingleThreadExecutor().submit(abstractActionFactory.get(ActionName.of(actionName)).create(ctx, state, s));
        LOGGER.debug("leaving channel handler");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        Utils.log(ctx.channel().remoteAddress(), "Channel Inactive");
    }
}
