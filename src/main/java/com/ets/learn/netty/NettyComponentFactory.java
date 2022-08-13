package com.ets.learn.netty;


public class NettyComponentFactory {

    public static NettyComponent build(){
        return DaggerNettyComponent.builder().build();
    }
}
