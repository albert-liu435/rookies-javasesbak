package com.java.nio.buffer;

import com.art.concurrent.book.chapter05.Cache;
import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.LongBuffer;

/**
 * @Classname HeapByteBufferDemo
 * @Description TODO
 * @Author rookie
 * @Date 2022/2/16 15:55
 * @Version 1.0
 */
public class ByteBufferDemo {



    @Test
    public void TestHeapByteBuffer1() throws Exception{
        //填充
        ByteBuffer bf = ByteBuffer.allocate(10);
        bf.put( (byte)'h' );
        bf.put( (byte)'e' );
        bf.put( (byte)'l' );
        bf.put( (byte)'l' );
        bf.put( (byte)'o' );

        //进行翻转
        bf.flip();
        byte b1 = bf.get();
        System.out.println(b1);




    }

    @Test
    public void testAsCharBuffer1(){
        ByteBuffer bb = ByteBuffer.wrap("Some text".getBytes());
        CharBuffer cb = bb.asCharBuffer();
        String s = cb.toString();
        System.out.print(s);

//        ByteBuffer bf = ByteBuffer.allocate(10);
//        bf.put( (byte)'S' );
//        bf.put( (byte)'o' );
//        bf.put( (byte)'m' );
//        bf.put( (byte)'e' );
//        bf.put( (byte)' ' );
//        bf.put( (byte)'t' );
//        bf.put( (byte)'e' );
//        bf.put( (byte)'x' );
//        bf.put( (byte)'t' );
//        CharBuffer cb = bf.asCharBuffer();
//        cb.flip();
//        String s = cb.toString();
//        System.out.print(s);


    }

    @Test
    public void testAsCharBuffer2(){
                ByteBuffer bf = ByteBuffer.allocate(10);
        bf.put( (byte)'S' );
        bf.put( (byte)'o' );
        bf.put( (byte)'m' );
        bf.put( (byte)'e' );
        bf.put( (byte)' ' );
        bf.put( (byte)'t' );
        bf.put( (byte)'e' );
        bf.put( (byte)'x' );
        bf.put( (byte)'t' );
        bf.flip();

        CharBuffer cb = bf.asCharBuffer();
       // cb.flip();
        String s = cb.toString();
        System.out.print(s);
    }


    @Test
    public void testAsLongBuffer1() throws Exception{
        int n = 50;
            ByteBuffer bufferB = ByteBuffer.allocate(n);
            LongBuffer bufferL = bufferB.asLongBuffer();
            bufferL.put(5000);
            bufferL.put(9000);
            bufferL.put(2000);
            bufferL.put(8000);
            bufferL.put(3000);
            bufferL.rewind();
            long l;
            System.out.print("The LongBuffer is: ");
            while ((l = bufferL.get()) != 0) {
                System.out.print(l + " ");
            }
    }
}
