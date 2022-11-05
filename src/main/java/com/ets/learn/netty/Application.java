package com.ets.learn.netty;

public class Application {

    public static void main(String[] args) {

        Application application = new Application();

//        Throwable throwable = application.returnThrowable();
//        System.out.println(throwable);
//        System.out.println(throwable.getCause());


        if (args.length == 0) {
            System.out.println("Usage: Main [port number]");
            System.exit(1);
        }
        try {


            NettyComponents n = NettyComponentsFactory.build();
//            n.providesHandlerFactory();

            SimpleNettyServerBootstrap simpleNettyServerBootstrap = new SimpleNettyServerBootstrap(new SimpleTCPChannelInitializer(n.providesHandlerFactory()));
            simpleNettyServerBootstrap.start(Integer.valueOf(args[0]));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Throwable returnThrowable(){
        return new TestThrowable();
    }

}
