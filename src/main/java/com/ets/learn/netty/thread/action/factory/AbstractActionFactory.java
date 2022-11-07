package com.ets.learn.netty.thread.action.factory;

import com.ets.learn.netty.thread.action.Action;
import com.ets.learn.netty.thread.action.ActionFactory;
import com.ets.learn.netty.thread.action.ActionName;

public interface AbstractActionFactory<K extends ActionName, V extends ActionFactory> {

    V get(K actionName);

}
