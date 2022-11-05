package com.ets.learn.netty;

import com.ets.learn.netty.handler.HandlerFactory;
import dagger.Component;
import io.netty.handler.codec.string.StringDecoder;

import javax.inject.Singleton;

@Singleton
@Component(modules = NettyModule.class)
public interface NettyComponents {

    HandlerFactory providesHandlerFactory();

//    @Component.Factory
//    interface Factory {
//        NettyComponents newNettyComponents(NettyModule nettyModule);
//    }

}
