package com.ets.learn.netty;

import com.ets.learn.netty.handler.HandlerFactory;
import com.ets.learn.netty.thread.action.factory.AbstractActionsFactory;
import com.ets.learn.netty.thread.state.State;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = NettyModule.class)
public interface NettyComponents {

    HandlerFactory providesHandlerFactory();

    @Singleton
    State providesState();

    @Singleton
    AbstractActionsFactory providesAbstractActionsFactory();

//    @Component.Factory
//    interface Factory {
//        NettyComponents newNettyComponents(NettyModule nettyModule);
//    }

}
