package com.ets.learn.netty;

public class Application {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Usage: Main [port number]");
            System.exit(1);
        }
        try {
            SimpleNettyServerBootstrap simpleNettyServerBootstrap = new SimpleNettyServerBootstrap();
            simpleNettyServerBootstrap.start(Integer.valueOf(args[0]));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
