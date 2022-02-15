package com.rookie.bigdata.nio.nionet.executor;

/**
 * @Classname NetworkSocket_client
 * @Description TODO
 * @Author rookie
 * @Date 2022/1/21 17:01
 * @Version 1.0
 */


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

//客户端
public class NetworkSocket_client implements Runnable {
    /**
     * 线程池启动客户端测试
     */
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("客户端开启。。。");
            String clientFile="H:\\copyToFile\\aaa.log";
            NetworkSocket_client networkSocket_client=new NetworkSocket_client();


            networkSocket_client.netByBlockingNIO2Client(clientFile);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void netByBlockingNIO2Client(String localFile) throws IOException {
        localFile="H:\\copyToFile\\aaa.log";
        //1.1.1获取socket通道,地址和端口
        SocketChannel socketChannel1=SocketChannel.open(new InetSocketAddress("127.0.0.1",9090));
        //1.1.2获取本地文件输入通道
        FileChannel fileChannel1_in=FileChannel.open(Paths.get(localFile), StandardOpenOption.READ);

        //1.1.3 分配指定大小的缓冲区
        ByteBuffer byteBuffer1=ByteBuffer.allocate(1024);
        int i=1;
        //1.1.4读取本地文件，并发送到服务端
        while(fileChannel1_in.read(byteBuffer1) !=-1){//将数据写满缓冲区，遍历
            System.out.println("客户端发送文件到服务端 "+i++);
            byteBuffer1.flip();//缓冲区反转
            socketChannel1.write(byteBuffer1);//将缓冲区数据写入socket通道
            byteBuffer1.clear();//读完，清空缓冲区
        }

        //1.1.5 关闭通道
        socketChannel1.close();
        fileChannel1_in.close();
    }
}



