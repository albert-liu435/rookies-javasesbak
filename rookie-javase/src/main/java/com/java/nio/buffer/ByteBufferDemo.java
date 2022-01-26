package com.java.nio.buffer;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * @Classname ByteBufferDemo
 * @Description TODO
 * @Author rookie
 * @Date 2022/1/20 11:01
 * @Version 1.0
 */
public class ByteBufferDemo {


    /**
     * https://blog.csdn.net/prestigeding/article/details/53980790
     */
    @Test
    public void test1(){

        ByteBuffer bf = ByteBuffer.allocate(10);
        bf.put( (byte)'h' );
        bf.put( (byte)'e' );
        bf.put( (byte)'l' );
        bf.put( (byte)'l' );
        bf.put( (byte)'o' );
        //bf.put( (byte)'o' );bf.put( (byte)'o' );bf.put( (byte)'o' );bf.put( (byte)'o' );bf.put( (byte)'o' );bf.put( (byte)'o' );bf.put( (byte)'o' );bf.put( (byte)'o' );bf.put( (byte)'o' );bf.put( (byte)'o' );bf.put( (byte)'o' );bf.put( (byte)'o' );bf.put( (byte)'o' );bf.put( (byte)'o' );bf.put( (byte)'o' );bf.put( (byte)'o' );bf.put( (byte)'o' );bf.put( (byte)'o' );

       // bf.limit(bf.position()).position(0);

//        byte b1 = bf.get();
//        System.out.println(b1);

        bf.flip();
                byte b1 = bf.get();
        System.out.println(b1);


        boolean b2 = bf.hasRemaining();
        System.out.println(b2);

        for(int i=0;bf.hasRemaining();i++){
            System.out.println(bf.get());
        }


        byte b = bf.get(1);
        System.out.println(b);

    }
}
