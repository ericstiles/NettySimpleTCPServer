package com.ets.learn.netty.thread.state;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import javax.inject.Inject;

//@RequiredArgsConstructor(staticName = "of", onConstructor=@__(@Inject))
@Data
public class State {

    @Inject
    public State(){};

    boolean cancelTransaction;

}
