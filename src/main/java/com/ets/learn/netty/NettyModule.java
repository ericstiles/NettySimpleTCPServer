package com.ets.learn.netty;

import dagger.Module;
import dagger.Provides;
import io.netty.handler.codec.string.StringDecoder;

@Module
public class NettyModule {

    @Provides
    StringDecoder providesStringDecoder(){
        return new StringDecoder();
    }
}
