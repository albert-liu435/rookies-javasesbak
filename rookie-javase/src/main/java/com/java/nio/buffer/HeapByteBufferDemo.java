package com.java.nio.buffer;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * @Classname HeapByteBufferDemo
 * @Description TODO
 * @Author rookie
 * @Date 2022/2/18 10:46
 * @Version 1.0
 */
public class HeapByteBufferDemo {


    @Test
    public void slice()throws Exception{
        //填充
        ByteBuffer bf = ByteBuffer.allocate(10);
        bf.put((byte) 'M');
        bf.put((byte) 'e');
        bf.put((byte) 'l');
        bf.put((byte) 'l');
        bf.put((byte) 'o');
        bf.put((byte) 'w');

        //进行翻转
        bf.flip();
        //释放两个字节元素的缓冲区
        for (int i = 0; i<2; i++) {
            byte b1 = bf.get();
            //打印出16进制
//            String hex = Integer.toHexString(b1 & 0xFF);
//            System.out.println(hex);
            System.out.println((char)b1);
        }
        System.out.println("新的字节缓冲区");

        ByteBuffer slice = bf.slice();

        //释放字节元素的缓冲区
        for (int i = 0; slice.hasRemaining(); i++) {
            byte b1 = slice.get();
            System.out.println((char)b1);
        }


    }

    @Test
    public void duplicate()throws Exception{
        //填充
        ByteBuffer bf = ByteBuffer.allocate(10);
        bf.put((byte) 'M');
        bf.put((byte) 'e');
        bf.put((byte) 'l');
        bf.put((byte) 'l');
        bf.put((byte) 'o');
        bf.put((byte) 'w');

        //进行翻转
        bf.flip();
        //释放两个字节元素的缓冲区
        for (int i = 0; i<2; i++) {
            byte b1 = bf.get();
            //打印出16进制
//            String hex = Integer.toHexString(b1 & 0xFF);
//            System.out.println(hex);
            System.out.println((char)b1);
        }
        System.out.println("新的字节缓冲区");

        ByteBuffer slice = bf.duplicate();

        //释放字节元素的缓冲区
        for (int i = 0; slice.hasRemaining(); i++) {
            byte b1 = slice.get();
            System.out.println((char)b1);
        }

    }



    @Test
    public void order()throws Exception{
        ByteBuffer bf = ByteBuffer.allocate(10);

        ByteOrder order = bf.order();
        System.out.println(order);
    }

}
