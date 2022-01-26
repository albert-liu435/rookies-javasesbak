package com.java.nio.buffer;

import java.nio.ByteOrder;
import java.nio.CharBuffer;

/**
 * @Classname CharbufferDemo
 * @Description TODO
 * @Author rookie
 * @Date 2022/1/21 15:34
 * @Version 1.0
 */
public class CharbufferDemo {

    public static void main(String[] args) {
        CharBuffer charBuffer=CharBuffer.allocate(100);

//        char[] myArray=new char[100];
//        CharBuffer charBuffer1=CharBuffer.wrap(myArray);
       // CharBuffer charbuffer = CharBuffer.wrap (myArray, 12, 42);


        System.out.println(ByteOrder.nativeOrder());
    }

}
