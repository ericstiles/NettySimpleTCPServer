package com.ets.learn.netty.thread.action;

public interface Action<K> extends Runnable{
    public  K  getActionName();
}
