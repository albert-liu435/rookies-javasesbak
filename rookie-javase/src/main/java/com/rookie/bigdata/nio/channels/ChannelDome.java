package com.rookie.bigdata.nio.channels;

/**
 * @Classname ChannelDome
 * @Description TODO
 * @Author rookie
 * @Date 2022/1/21 16:52
 * @Version 1.0
 */


import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 通道channel：
 * 用于源节点与目标节点的连接，本身不负责存储数据，主要是配合缓冲区，负责数据的运输。
 * 1.主要的实现类：
 *      java.nio.channels.Channel接口
 *          --用于本地文件：
 *              -FileChannel
 *          --用于网络
 *              -SocketChannel一般用于客户端,TCP协议
 *              -ServerSocketChannel一般用于服务端，TCP协议
 *              -DatagramChannel基于UDP协议，主要用于发送和接收数据包
 * 2.获取通道Channel的方法
 * （1）java针对支持通道的类提供了getChannel()方法
 *      --本地文件
 *      FileInputStream/FileOutoutStream
 *      RandomAccessFile
 *      --网络传输
 *      Socket
 *      ServerSocket
 *      DatagramSocket
 *  (2)在JDK1.7中的NIO2针对各个通道提供了静态方法open()
 *  (3)在JDK1.7中的NIO2中Files工具类newByteChannel()
 * 3.通道之间的传输,两种方法
 * transferForm()
 * transferTo()
 *
 */
public class ChannelDome {

    /**
     *    main测试,利用线程池进行创建线程并运行。
     */

    public static void main(String[] args)  {
        //1.创建可重用固定线程数量的线程池
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        //System.out.println(executorService.getClass());//查看调用了那个接口的对应实现类。
        //2.执行指定的线程的操作，需要提供的是Runnable接口或Callable接口实现类的对象
        copyFileThread1 thread1=new copyFileThread1();
        copyFileThread2 thread2=new copyFileThread2();
        channelWriteAndRead thread3=new channelWriteAndRead();
        channelTransfer thread4=new channelTransfer();
        executorService.execute(thread1);
        executorService.execute(thread2);
        executorService.execute(thread3);
        executorService.execute(thread4);
        //executorService.submit();
        executorService.shutdown();

    }
    /**
     * 1.利用通道进行本地文件的复制功能（非直接缓冲区）
     * @param copyFrom
     * @param copyTo
     * @return boolean
     */
    public boolean copyFileByChannel(String copyFrom,String copyTo) throws IOException {
        long start=System.currentTimeMillis();
        boolean result=false;
        FileInputStream inputStream=null;
        FileOutputStream outputStream=null;
        FileChannel inputChannel=null;
        FileChannel outputChannel=null;
        try {
            //1.获取本地输入输出流
            inputStream = new FileInputStream(copyFrom);
            outputStream = new FileOutputStream(copyTo);

            //2.获取本地对应输入输出通道
            inputChannel = inputStream.getChannel();
            outputChannel = outputStream.getChannel();

            //3.分配指定大小的缓冲区
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

            //4.将输入通道中的数据存入缓冲区
            while (inputChannel.read(byteBuffer) != -1) {//从当前通道position读取数据到缓冲区，若到达末尾，返回-1
                byteBuffer.flip();//切换到读取数据模式
                //5.将缓冲区的数据写入到输出通道中
                outputChannel.write(byteBuffer);
                byteBuffer.clear();//清空缓冲区
                result=true;
            }

        }finally {
            if(inputStream !=null){
                inputStream.close();
            }
            if(inputChannel !=null){
                inputChannel.close();
            }
            if(outputChannel !=null){
                outputChannel.close();
            }
            if(outputStream !=null){
                outputStream.close();
            }
        }
        long end=System.currentTimeMillis();
        System.out.println("非缓冲区复制文件耗时："+(end-start));
        return  result;
    }

    /**
     * 2.利用通道进行本地文件的复制功能（直接缓冲区，利用内存映射文件）
     * @param  copyFrom
     * @param  copyTo
     * @return boolean
     */
    public boolean copyFileByChannel2Direct(String copyFrom,String copyTo) throws IOException {
        long start=System.currentTimeMillis();
        //1.获取输入输出通道
        FileChannel inputChannel= FileChannel.open(Paths.get(copyFrom), StandardOpenOption.READ);
        FileChannel outputChannel=FileChannel.open(Paths.get(copyTo),StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);
        //2.获取内存映射文件
        MappedByteBuffer inMappedBuf=inputChannel.map(FileChannel.MapMode.READ_ONLY,0,inputChannel.size());
        MappedByteBuffer outMappedBuf=outputChannel.map(FileChannel.MapMode.READ_WRITE,0,inputChannel.size());
        //3.直接对缓冲区进行读写操作
        byte[] dst=new byte[inMappedBuf.limit()];
        inMappedBuf.get(dst);
        outMappedBuf.put(dst);
        //4.关闭输入输出通道
        inputChannel.close();
        outputChannel.close();
        long end =System.currentTimeMillis();
        System.out.println("直接缓冲区复制的耗时："+(end-start));
        return true;
    }

    /**
     * 3.通道之间的数据传输（直接缓冲区）
     * @param  copyFrom
     * @param copyTo
     * @return boolean
     */
    public boolean copyFileByChannel2Transfer(String copyFrom,String copyTo) throws IOException {
        FileChannel inChannel=FileChannel.open(Paths.get(copyFrom),StandardOpenOption.READ);
        FileChannel outChannel=FileChannel.open(Paths.get(copyTo),StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);
        //1.将通道中的字节数据传输到指定通道，transferTo()
        inChannel.transferTo(0,inChannel.size(),outChannel);
        //2.从指定通道中获取自己数据到通道中，transferFrom()
        //outChannel.transferFrom(inChannel,0,inChannel.size());
        return true;
    }

    /**
     * 4.通道的分散和聚合
     *分散读取：将通道的数据读取到多个缓冲区Bufer中
     * 聚集写入：将多个缓冲区的数据聚集写到通道Channel中
     * @param writeFlie
     * @param readFlie
     */
    public void channelWriteAndRead(String writeFlie,String readFlie) throws IOException {
        //1.读取指定文件
        RandomAccessFile randomAccessFile=new RandomAccessFile(readFlie,"rw");
        //2.获取本地文件通道
        FileChannel fileChannel=randomAccessFile.getChannel();

        //3.分配指定大小的缓冲区
        ByteBuffer buf1=ByteBuffer.allocate(1024);//设置多大就缓存多大
        ByteBuffer buf2=ByteBuffer.allocate(1024);
        //4.分散读取
        ByteBuffer[] bufs={buf1,buf2};
        fileChannel.read(bufs);

        for(ByteBuffer byteBuffer:bufs){
            byteBuffer.flip();
            System.out.println("每个缓冲区的数据如下：");
            System.out.println(new String(byteBuffer.array(),0,byteBuffer.limit()));

        }
        //5.聚集写入(指定文件)
        RandomAccessFile randomAccessFile1=new RandomAccessFile(writeFlie,"rw");//指定写到那个文件下
        FileChannel fileChannel1=randomAccessFile1.getChannel();
        fileChannel1.write(bufs);
    }


}

//创建线程1测试,非缓冲区文件复制
class copyFileThread1 implements Runnable{
    ChannelDome channelDome=new ChannelDome();
    String copyFrom="G:\\copyFromFile\\copyForm.log";
    String copyTo="H:\\copyToFile\\NoDirect\\copyTo1.log";
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread() +"当前线程正在执行利用非缓冲区本地文件复制功能");
            channelDome.copyFileByChannel(copyFrom,copyTo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//创建线程2测试，
class copyFileThread2 implements Runnable{
    ChannelDome channelDome =new ChannelDome();
    String copyFrom="G:\\copyFromFile\\copyForm.log";
    String copyTo="H:\\copyToFile\\Direct\\copyTo2.log";
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread() +"当前线程正在执行利用缓冲区本地文件复制功能");
            channelDome.copyFileByChannel2Direct(copyFrom,copyTo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//通道的分散读取和聚集写入线程测试
class channelWriteAndRead implements Runnable{

    ChannelDome channelDome=new ChannelDome();
    String writeFile="G:\\copyFromFile\\copyForm.log";
    String readFile="H:\\copyToFile\\Read\\read.log";

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread() +"当前线程正在执行通道的分散读取和聚集写入线程功能");
            channelDome.channelWriteAndRead(readFile,writeFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//通道之间的传输线程测试
class channelTransfer implements Runnable{
    ChannelDome channelDome=new ChannelDome();
    String copyForm="G:\\copyFromFile\\copyForm.log";
    String copyTo="H:\\copyToFile\\transfer\\transfer.log";
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread() +"当前线程正在执行通道之间的传输线程功能");
            channelDome.copyFileByChannel2Transfer(copyForm,copyTo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
