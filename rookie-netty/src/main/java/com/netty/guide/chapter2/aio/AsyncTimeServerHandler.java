package com.netty.guide.chapter2.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * @Classname AsyncTimeServerHandler
 * @Description TODO
 * @Author rookie
 * @Date 2022/3/3 14:54
 * @Version 1.0
 */
public class AsyncTimeServerHandler implements Runnable {

    private int port;

    CountDownLatch latch;
    AsynchronousServerSocketChannel asynchronousServerSocketChannel;

    public AsyncTimeServerHandler(int port) {
        this.port = port;
        try {
            //一步去的服务端通道
            asynchronousServerSocketChannel = AsynchronousServerSocketChannel
                    .open();
            //绑定监听端口
            asynchronousServerSocketChannel.bind(new InetSocketAddress(port));
            System.out.println("The time server is start in port : " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        //初始化CountDownLatch对象，在完成一组正在执行的操作之前，运行当前的线程一直阻塞
        latch = new CountDownLatch(1);
        doAccept();
        try {
            //这里会一直阻塞
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello java");
    }

    public void doAccept() {
        asynchronousServerSocketChannel.accept(this,
                new AcceptCompletionHandler());
    }

}
