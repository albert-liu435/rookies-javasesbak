package com.rookie.bigdata.nio.nionet.executor;

/**
 * @Classname NetworkSocketDemo
 * @Description TODO
 * @Author rookie
 * @Date 2022/1/21 17:05
 * @Version 1.0
 */


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 一、使用 NIO 完成网络通信的三个核心：
 * <p>
 * 1. 通道（Channel）：负责连接
 * <p>
 * java.nio.channels.Channel 接口：
 * |--SelectableChannel
 * |--SocketChannel
 * |--ServerSocketChannel
 * |--DatagramChannel
 * <p>
 * |--Pipe.SinkChannel
 * |--Pipe.SourceChannel
 * <p>
 * 2. 缓冲区（Buffer）：负责数据的存取
 * <p>
 * 3. 选择器（Selector）：是 SelectableChannel 的多路复用器。用于监控 SelectableChannel 的 IO 状况
 */
public class NetworkSocketDemo {

    //main测试类
    public static void main(String[] args) {

        //1.阻塞NIO
        //客户端
        NetworkSocket_client client = new NetworkSocket_client();
        //服务端
        NetworkSocket_server server = new NetworkSocket_server();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
        executorService.execute(client);
        executorService.execute(server);
        executorService.shutdown();

    }
}

