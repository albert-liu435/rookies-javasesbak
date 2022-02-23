package com.netty.guide.nio;

/**
 * @Classname TimeClient
 * @Description TODO
 * @Author rookie
 * @Date 2022/2/23 11:05
 * @Version 1.0
 */
public class TimeClient {
    public static void main(String[] args) {
        int port = 8080;
        new Thread(new TimeClientHandle("127.0.0.1", port), "TimeClient-001").start();

    }
}
