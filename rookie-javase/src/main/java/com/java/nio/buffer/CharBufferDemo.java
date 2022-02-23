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
    public void CharBufferTest() {
        //从堆空间中分配100个char变量的数组
        CharBuffer charBuffer = CharBuffer.allocate(100);

        //对缓冲区的改动会影响数组，同理对赎罪的改动也会影响缓冲区
        char[] myArray = new char[100];
        CharBuffer charbuffer1 = CharBuffer.wrap(myArray);

        //position值为12，limit值为54，容量为myArray.length的缓冲区
        CharBuffer wrap = CharBuffer.wrap(myArray, 12, 42);

    }


    @Test
    public void CharBufferTest1()throws Exception{
        String s = "hello";

        CharBuffer buffer = CharBuffer.allocate(10);
        for (int i = 0; i < s.length(); i++){
            buffer.put(s.charAt(i));
        }

        // 将第一个位置的字符h换为M，并填入一个新的字符w
        buffer.put(0,'M').put('w');

        // 现在缓冲区的元素是Mellow，position的位置是6，limit和capacity都是10
        // 调用flip方法得到有效元素的位置，其实也就是position的位置
        buffer.flip();

        // 将M和e两个个字符释放掉
        System.out.println("release char " + buffer.get());
        System.out.println("release char " + buffer.get());

        // 调用compact方法可以回收M和e字符占用的空间
        // 调用compact后position位置是4，
        // 0-3位置的字符依次是llow，4-5位置的字符依次是ow
        // 虽然4-5位置有字符，但是调用put方法后会被重写
        // 并且调用compact方法后limit又回到了capacity的位置，也就是10
        buffer.compact();

        // 将4-5位置的字符修改为ab
        buffer.put('a').put('b');

        // 输出缓冲区的元素，根据上面的分析，最后输出的字符应该是llowab
        // 需要先调用flip方法将position设为0，这样才能读到完整的字符
        buffer.flip();
        while (buffer.hasRemaining()){
            System.out.println("print output " + buffer.get());
        }

    }


    @Test
    public void wrap() throws Exception {
        CharBuffer charBuffer = CharBuffer.wrap("Hello World");


    }


    @Test
    public void order() throws Exception {
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

