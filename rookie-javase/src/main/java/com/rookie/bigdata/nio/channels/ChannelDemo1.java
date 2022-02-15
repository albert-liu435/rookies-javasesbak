package com.rookie.bigdata.nio.channels;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * @Classname ChannelDemo
 * @Description TODO
 * @Author rookie
 * @Date 2021/12/20 11:04
 * @Version 1.0
 */
public class ChannelDemo1 {

    public static void main(String[] args) throws Exception {


       // String relativelyPath = System.getProperty("user.dir");
        String sourceFile="C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\java\\com\\java\\nio\\channels\\ChannelDemo.java";
        String destinationFile="C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\java\\com\\java\\nio\\channels\\a.java";
        //FileInputStream input = new FileInputStream(relativelyPath + "/testin.txt");
        FileInputStream input = new FileInputStream(sourceFile);
        ReadableByteChannel source = input.getChannel();
       // FileOutputStream output = new FileOutputStream(relativelyPath + "/testout.txt");
        FileOutputStream output = new FileOutputStream(destinationFile);

        WritableByteChannel destination = output.getChannel();

        copyData(source, destination);
        source.close();
        destination.close();
        System.out.println("Copy Data finished");


    }

    private static void copyData(ReadableByteChannel source, WritableByteChannel destination) throws Exception{
        ByteBuffer buffer = ByteBuffer.allocateDirect(20 * 1024);
        while (source.read(buffer) != -1) {
            // The buffer is used to drained
            buffer.flip();
            // keep sure that buffer was fully drained
            while (buffer.hasRemaining()) {
                destination.write(buffer);
            }
            buffer.clear(); // Now the buffer is empty, ready for the filling
        }
        //原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/java_nio/java-nio-channels.html


    }
}
