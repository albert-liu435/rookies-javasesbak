package com.java.nio.channels;

import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * @Classname ByteChannelDemo
 * @Description TODO
 * @Author rookie
 * @Date 2022/2/21 15:53
 * @Version 1.0
 */
public class ByteChannelDemo {


    public static void main(String[] args) throws Exception{
        ReadableByteChannel source = Channels.newChannel(System.in);
        WritableByteChannel dest = Channels.newChannel(System.out);


        //ByteBuffer buffer = ByteBuffer.allocateDirect(16 * 1024);
        ByteBuffer buffer = ByteBuffer.allocate(16 * 1024);
        //从通道中读取数据
        while (source.read(buffer) != -1) {

            buffer.flip();
            //写入到通道
            dest.write(buffer);

            buffer.compact();
            //添加一个字节h
            buffer.put((byte) 'a');
        }

        buffer.flip();
        while (buffer.hasRemaining()) {
            dest.write(buffer);
        }


        source.close();
        dest.close();
    }





    @Test
    public void test1() throws Exception {

        ReadableByteChannel source = Channels.newChannel(System.in);
        WritableByteChannel dest = Channels.newChannel(System.out);

        ByteBuffer buffer = ByteBuffer.allocateDirect(16 * 1024);
        //从通道中读取数据
        while (source.read(buffer) != -1) {

            buffer.flip();
            //写入到通道
            dest.write(buffer);

            buffer.compact();
        }

        buffer.flip();
        while (buffer.hasRemaining()) {
            dest.write(buffer);
        }


        source.close();
        dest.close();
    }

    private static void channelCopy2(ReadableByteChannel src, WritableByteChannel dest) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocateDirect(16 * 1024);
        while (src.read(buffer) != -1) {
            // Prepare the buffer to be drained
            // buffer.flip( );
            // Make sure that the buffer was fully drained
            while (buffer.hasRemaining()) {
                dest.write(buffer);
            }
            // Make the buffer empty, ready for filling
            buffer.clear();
        }
    }
}
