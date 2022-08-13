package com.ets.learn.netty;


public class NettyComponentsFactory {

    public static NettyComponents build(){
        return DaggerNettyComponents.builder().build();
    }
}
