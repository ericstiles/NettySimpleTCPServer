package com.ets.learn.netty;

import com.ets.learn.netty.thread.action.ActionName;
import com.ets.learn.netty.thread.action.message.MessageAction;
import com.ets.learn.netty.thread.action.factory.AbstractActionsFactory;
import com.ets.learn.netty.thread.action.message.MessageActionFactory;
import com.ets.learn.netty.thread.action.stop.StopActionFactory;
import dagger.Module;
import dagger.Provides;
import io.netty.handler.codec.string.StringDecoder;

import java.util.Arrays;

@Module
public class NettyModule {

    @Provides
    StringDecoder providesStringDecoder(){
        return new StringDecoder();
    }

//    @Provides
//    AbstractActionsFactory providesMessageActionFactory(){
//        return new AbstractActionsFactory();
//
//    }

}
