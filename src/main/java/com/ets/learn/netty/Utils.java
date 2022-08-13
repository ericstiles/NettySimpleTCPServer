package com.ets.learn.netty;

import java.net.SocketAddress;

public final class Utils {

    static void log(String message){
        System.out.println(message);
    }

    public static void log(SocketAddress socketAddress, String message){
        System.out.println("< " + socketAddress + " > : " + message);
    }

    public static void log(int id, SocketAddress socketAddress, String message){
        System.out.println("id: " + id + " < " + socketAddress + " > : " + message);
    }

}
