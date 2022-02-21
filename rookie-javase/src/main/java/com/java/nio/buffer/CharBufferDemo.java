package com.java.nio.buffer;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;

/**
 * @Classname CharBufferDemo
 * @Description TODO
 * @Author rookie
 * @Date 2022/2/16 16:42
 * @Version 1.0
 */
public class CharBufferDemo {




    @Test
    public void CharBufferTest(){
        //从堆空间中分配100个char变量的数组
        CharBuffer charBuffer = CharBuffer.allocate(100);

        //对缓冲区的改动会影响数组，同理对赎罪的改动也会影响缓冲区
        char [] myArray = new char [100];
        CharBuffer charbuffer1 = CharBuffer.wrap (myArray);

    }

    @Test
    public void wrap()throws Exception{
        CharBuffer charBuffer = CharBuffer.wrap("Hello World");



    }



    @Test
    public void order()throws Exception{
        CharBuffer bf = CharBuffer.allocate(10);

        ByteOrder order = bf.order();
        System.out.println(order);
    }




//    public static void main(String[] argv) throws Exception {
//        CharBuffer buffer = CharBuffer.allocate(100);
//        while (fillBuffer(buffer)) {
//            buffer.flip();
//            drainBuffer(buffer);
//            buffer.clear();
//        }
//    }

    private static void drainBuffer(CharBuffer buffer) {
        while (buffer.hasRemaining()) {
            System.out.print(buffer.get());
        }
        System.out.println("");
    }

    private static boolean fillBuffer(CharBuffer buffer) {
        if (index >= strings.length) {
            return (false);
        }
        String string = strings[index++];
        for (int i = 0; i < string.length(); i++) {
            buffer.put(string.charAt(i));
        }
        return (true);
    }

    private static int index = 0;
    private static String[] strings = {"A random string value", "The product of an infinite number of monkeys", "Hey hey we're the Monkees", "Opening act for the Monkees: Jimi Hendrix", "'Scuse me while I kiss this fly", "Help Me! Help Me!",};
}

