package com.ets.learn.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

class SimpleNettyServerBootstrap {

    ChannelInitializer channelInitializer;

    public SimpleNettyServerBootstrap(ChannelInitializer channelInitializer){
        this.channelInitializer = channelInitializer;
    }

    void start(int port) throws InterruptedException {
        Utils.log("Starting server at: " + port);
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new SimpleTCPChannelInitializer())
                    .childHandler(channelInitializer)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            // Bind and start to accept incoming connections.
            ChannelFuture f = b.bind(port).sync();
            if(f.isSuccess()) Utils.log("Server started successfully");
            f.channel().closeFuture().sync();
        } finally {
            Utils.log("Stopping server");
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

}
