package com.java.nio.channels;

import org.junit.Test;

import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @Classname SocketChannelDemo
 * @Description TODO
 * @Author rookie
 * @Date 2022/2/21 15:44
 * @Version 1.0
 */
public class SocketChannelDemo {


    @Test
    public void test1() throws Exception {
        SocketChannel sc = SocketChannel.open();

        sc.connect(new InetSocketAddress(8081));

        ServerSocketChannel ssc = ServerSocketChannel.open();
        sc.socket().bind(new InetSocketAddress(8082));

        DatagramChannel dc = DatagramChannel.open();


        RandomAccessFile raf = new RandomAccessFile("somefile", "r");
        FileChannel channel = raf.getChannel();


    }


    @Test
    public void ConnectAsync() throws Exception {

        InetSocketAddress addr = new InetSocketAddress("127.0.0.1", 9999);
        SocketChannel sc = SocketChannel.open();
        sc.configureBlocking(false);
        System.out.println("initiating connection");
        sc.connect(addr);
        while (!sc.finishConnect()) {
            System.out.println("doing something useless");
        }
        System.out.println("connection established"); // Do something with the connected socket // The SocketChannel is still nonblocking
        sc.close();

    }


}
