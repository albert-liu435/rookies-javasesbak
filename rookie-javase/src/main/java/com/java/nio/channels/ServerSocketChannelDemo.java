package com.java.nio.channels;

import org.junit.Test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * @Classname ServerSocketChannelDemo
 * @Description TODO
 * @Author rookie
 * @Date 2022/2/22 15:40
 * @Version 1.0
 */
public class ServerSocketChannelDemo {


    @Test
    public void testServerSocketChannel() throws Exception {

        ByteBuffer buffer = ByteBuffer.wrap("Hello I must be going.\r\n".getBytes(StandardCharsets.UTF_8));
        //打开ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //绑定端口
        serverSocketChannel.socket().bind(new InetSocketAddress(9999));
        //设置为非阻塞模式
        serverSocketChannel.configureBlocking(false);


        while (true) {
            System.out.println("等待连接");
            //监听新进来的连接
            SocketChannel socketChannel =
                    serverSocketChannel.accept();

            if (socketChannel == null) {
                Thread.sleep(1000);
            } else {
                System.out.println("Incoming connection from: " + socketChannel.socket().getRemoteSocketAddress());
                buffer.rewind();
                socketChannel.write(buffer);
                socketChannel.close();
            }


        }
    }


    @Test
    public void testSocketChannel() throws Exception {
//        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("somehost", 1234));
//
//        SocketChannel socketChannel = SocketChannel.open();
//        socketChannel.connect(new InetSocketAddress("somehost", 1234));

    }

}
