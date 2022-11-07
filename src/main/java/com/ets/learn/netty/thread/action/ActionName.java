package com.ets.learn.netty.thread.action;

import lombok.RequiredArgsConstructor;

import lombok.NonNull;
import lombok.Value;

@Value(staticConstructor = "of")
public class ActionName {
    @NonNull
    String value;
}
