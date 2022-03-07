package com.netty.guide.chapter2.aio;

import java.io.IOException;

/**
 * @Classname TimeServer
 * @Description TODO
 * @Author rookie
 * @Date 2022/3/3 14:52
 * @Version 1.0
 */
public class TimeServer {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                // 采用默认值
            }
        }
        //异步的时间服务器处理类
        AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler(port);
        //启动线程
        new Thread(timeServer, "AIO-AsyncTimeServerHandler-001").start();
    }
}
