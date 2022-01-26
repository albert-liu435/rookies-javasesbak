package com.java.nio.nionet.executor;

/**
 * @Classname NetworkSocket_server
 * @Description TODO
 * @Author rookie
 * @Date 2022/1/21 17:02
 * @Version 1.0
 */


import org.junit.Test;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

//服务端
public class NetworkSocket_server implements Runnable {

    /**
     * 线程池启动服务端测试
     */
    @Override
    public void run() {
        String uploadFile="H:\\uploadFile\\bb.log";
        NetworkSocket_server networkSocket_server=new NetworkSocket_server();
        try {
            System.out.println("服务端开启。。。。");
            networkSocket_server.netByBlockingNIO2Server(uploadFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void netByBlockingNIO2Server(String uploadFile) throws IOException {

        //1.2.1获取通道
        ServerSocketChannel serverSocketChannel1=ServerSocketChannel.open();
        //1.2.2获取本地文件
        FileChannel fileChannel2_out=FileChannel.open(Paths.get(uploadFile), StandardOpenOption.WRITE,StandardOpenOption.CREATE);

        //1.2.3 绑定连接,开放本地9090为服务端口
        ServerSocketChannel bind = serverSocketChannel1.bind(new InetSocketAddress(9090));
        //1.2.4获取客户端连接的通道
        SocketChannel socketChannel1_client=serverSocketChannel1.accept();
        //1.2.5分配指定大小的缓冲区
        ByteBuffer byteBuffer1_server=ByteBuffer.allocate(1024);
        int i=1;
        //1.2.6接收客户端的数据，并保存到本地
        while(socketChannel1_client.read(byteBuffer1_server) !=-1){
            System.out.println("服务端读取文件保存本地"+i++);
            byteBuffer1_server.flip();
            fileChannel2_out.write(byteBuffer1_server);
            byteBuffer1_server.clear();
        }
        serverSocketChannel1.close();
        socketChannel1_client.close();
        fileChannel2_out.close();
    }
}



