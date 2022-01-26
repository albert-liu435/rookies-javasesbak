package com.java.nio.buffer;

import java.nio.CharBuffer;

/**
 * @Classname BufferDemo
 * @Description TODO
 * @Author rookie
 * @Date 2022/1/21 15:23
 * @Version 1.0
 */
public class BufferDemo1 {


    private static int index = 0;
    //// Sorry Jimi ;-)
    private static String[] strings = {"A random string value", "The product of an infinite number of monkeys", "Hey hey we're the Monkees", "Opening act for the Monkees: Jimi Hendrix", "'Scuse me while I kiss this fly", "Help Me! Help Me!",};

    public static void main(String[] args) {

        CharBuffer buffer = CharBuffer.allocate(100);

        while (fillBuffer(buffer)) {
            buffer.flip();
            drainBuffer(buffer);
            buffer.clear();

        }

    }

    private static void drainBuffer(CharBuffer buffer) {
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
        System.out.println("");
    }

    private static boolean fillBuffer(CharBuffer buffer) {

        if (index >= strings.length) {
            return false;
        }

        String string = strings[index++];

        for (int i = 0; i < string.length(); i++) {
            buffer.put(string.charAt(i));
        }


        return true;
    }
}
