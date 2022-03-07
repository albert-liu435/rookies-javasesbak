package com.netty.guide.chapter2.nio;

/**
 * @Classname TimeServer
 * @Description TODO
 * @Author rookie
 * @Date 2022/2/23 10:32
 * @Version 1.0
 */
public class TimeServer {

    public static void main(String[] args) {
        //设置监听端口
        int port=8080;
        //设置道路复用类，是一个代理的线程，负责轮询多路复用器Selctor
        MultiplexerTimeServer timeServer=new  MultiplexerTimeServer(port);

        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();


    }
}
