package com.java.nio.select;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @Classname SelectSockets
 * @Description TODO
 * @Author rookie
 * @Date 2022/2/24 17:29
 * @Version 1.0
 */
public class SelectSockets {
    public static int PORT_NUMBER = 1234;

    private ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

    public static void main(String[] args) throws Exception {
        new SelectSockets().go(args);

    }

    private void go(String[] args) throws Exception {
        int port = PORT_NUMBER;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }
        System.out.println("Listening on port " + port);


        // 1、创建Selector
        Selector selector = Selector.open();
        //2、创建ServerSocketChannel
        ServerSocketChannel serverChannel = ServerSocketChannel.open();

        ServerSocket serverSocket = serverChannel.socket();
        //3、绑定地址和端口
        serverSocket.bind(new InetSocketAddress(port));
        // 设置为非阻塞模式
        serverChannel.configureBlocking(false);
        //4、向Selector中注册Channel及感兴趣的事件，即丙丁监听事件，通过Selector监控serverChannel
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        //5、进行轮询查询就绪操作
        while (true) {
            //等待注册事件到达，否则一直阻塞
            int n = selector.select();
            if (n == 0) {
                continue;
            }
            //5、获取selector中选中项的迭代器，进行迭代
            Iterator it = selector.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey key = (SelectionKey) it.next();
                //针对感兴趣的事件进行处理，即针对OP_ACCEPT事件进行处理
                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    SocketChannel channel = server.accept();
                    registerChannel(selector, channel, SelectionKey.OP_READ);
                    sayHello(channel);
                }
                //针对感兴趣的事件进行处理，即针对OP_READ事件进行处理
                if (key.isReadable()) {
                    readDataFromSocket(key);
                }
                //事件处理完后将事件移除
                it.remove();
            }
        }


    }


    protected void registerChannel(Selector selector, SelectableChannel channel, int ops) throws Exception {
        if (channel == null) {
            return;
        }
        channel.configureBlocking(false);

        channel.register(selector, ops);
    }




    protected void readDataFromSocket(SelectionKey key) throws Exception {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        int count;
        buffer.clear();
        while ((count = socketChannel.read(buffer)) > 0) {
            buffer.flip();

            while (buffer.hasRemaining()) {
                socketChannel.write(buffer);
            }

            buffer.clear();
        }
        if (count < 0) {
            socketChannel.close();
        }
    }


    private void sayHello(SocketChannel channel) throws Exception {
        buffer.clear();
        buffer.put("Hi there!\r\n".getBytes());
        buffer.flip();
        channel.write(buffer);
    }

}
