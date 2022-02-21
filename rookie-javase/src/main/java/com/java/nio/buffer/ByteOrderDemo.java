package com.java.nio.buffer;

import org.junit.Test;

import java.nio.ByteOrder;

/**
 * @Classname ByteOrderDemo
 * @Description TODO
 * @Author rookie
 * @Date 2022/2/18 11:34
 * @Version 1.0
 */
public class ByteOrderDemo {


    @Test
    public void nativeOrder()throws Exception{

        System.out.println(ByteOrder.nativeOrder());
    }
}
