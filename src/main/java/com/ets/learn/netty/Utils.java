package com.ets.learn.netty;

import java.net.SocketAddress;

class Utils {

    static void log(String message){
        System.out.println(message);
    }

    static void log(SocketAddress socketAddress, String message){
        System.out.println("< " + socketAddress + " > : " + message);
    }

    static void log(int id, SocketAddress socketAddress, String message){
        System.out.println("id: " + id + " < " + socketAddress + " > : " + message);
    }

}
