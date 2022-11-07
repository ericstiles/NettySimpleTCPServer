package com.ets.learn.netty.thread.action.factory;

import com.ets.learn.netty.thread.action.Action;
import com.ets.learn.netty.thread.action.ActionFactory;
import com.ets.learn.netty.thread.action.ActionName;
import com.ets.learn.netty.thread.action.factory.AbstractActionFactory;
import com.ets.learn.netty.thread.action.message.MessageActionFactory;
import com.ets.learn.netty.thread.action.stop.StopActionFactory;
import lombok.NonNull;
import org.checkerframework.checker.units.qual.A;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

public class AbstractActionsFactory implements AbstractActionFactory<ActionName, ActionFactory> {

    Map<ActionName, ActionFactory> map = new HashMap<>();

    @Inject
    public AbstractActionsFactory(){
        MessageActionFactory messageActionFactory = MessageActionFactory.of(ActionName.of("message"));
        StopActionFactory stopActionFactory = StopActionFactory.of(ActionName.of("cancel"));
        map.put(messageActionFactory.getActionName(), messageActionFactory);
        map.put(stopActionFactory.getActionName(), stopActionFactory);


    }

    @SafeVarargs
    private AbstractActionsFactory(@NonNull ActionFactory<ActionName, Action<ActionName>>... actionFactories){
        for (ActionFactory<ActionName, Action<ActionName>> actionFactory : actionFactories) {
//            Check for duplicate
            map.put(actionFactory.getActionName(), actionFactory);
        }
    }

    @Override
    public ActionFactory get(ActionName actionName) {
        return map.get(actionName);
    }



//
//    @SafeVarargs
    public static AbstractActionsFactory of(@NonNull ActionFactory<ActionName, Action<ActionName>>... actionFactories){
        return new AbstractActionsFactory(actionFactories);
    }
//
//
    public static AbstractActionsFactory of(@NonNull ActionFactory<ActionName, Action<ActionName>> actionFactories){
//        return new AbstractActionsFactory(actionFactories);
        return new AbstractActionsFactory(actionFactories);
    }
}
