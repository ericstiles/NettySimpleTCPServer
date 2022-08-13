package com.ets.learn.netty;

import com.ets.learn.netty.handler.HandlerFactory;
import dagger.Binds;
import dagger.Component;
import dagger.Provides;

import javax.inject.Singleton;

@Singleton
@Component(modules = NettyModule.class)
public interface NettyComponent {

    HandlerFactory providesHandlerFactory();

}
