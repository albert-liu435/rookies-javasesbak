package com.java.io;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.PushbackInputStream;
import java.nio.charset.StandardCharsets;

/**
 * @Classname PushbackInputStreamDemo
 * @Description TODO
 * @Author rookie
 * @Date 2022/2/7 16:11
 * @Version 1.0
 */
public class PushbackInputStreamDemo {


    @Test
    public void test1() throws Exception {
        String s = "abcdefg";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8));
        PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream);
        int n;

        while ((n = pushbackInputStream.read()) != -1) {
            System.out.print((char) n);
            if ('b' == n) {
                pushbackInputStream.unread('U');
            }
        }


    }

    @Test
    public void test2() throws Exception {
        String s = "abcdefg";
        /*
         * PushbackInputStream pbin = new PushbackInputStream(in,3)
         * 这个构造函数创建的对象一次可以回推一个缓存
         */
        ByteArrayInputStream in = new ByteArrayInputStream(s.getBytes());
        PushbackInputStream pbin = new PushbackInputStream(in, 3);
        int n;
        byte[] buffer = new byte[3];
        while ((n = pbin.read(buffer)) != -1) {
            System.out.println(new String(buffer));
            if (new String(buffer).equals("abc")) pbin.unread(new byte[]{'M', 'N', 'O'});
            buffer = new byte[3];
        }

    }

    @Test
    public void test3() throws Exception {
        String s = "abcdefg";
        /*
         * PushbackInputStream pbin = new PushbackInputStream(in,4)
         * 这个构造函数创建的对象一次可以回推一个缓存
         */
        ByteArrayInputStream in = new ByteArrayInputStream(s.getBytes());
        PushbackInputStream pbin = new PushbackInputStream(in, 4);
        int n;
        byte[] buffer = new byte[4];
        while ((n = pbin.read(buffer)) != -1) {
            System.out.println(new String(buffer));
            //取回推缓存中的一部分数据
            if (new String(buffer).equals("abcd")) pbin.unread(buffer, 2, 2);
            buffer = new byte[4];
        }

    }


    @Test
    public void test10() throws Exception {
        String str = "www.baidu.com";        // 定义字符串
        PushbackInputStream push = null;        // 定义回退流对象
        ByteArrayInputStream bai = null;        // 定义内存输入流
        bai = new ByteArrayInputStream(str.getBytes());    // 实例化内存输入流
        push = new PushbackInputStream(bai);    // 从内存中读取数据
        System.out.print("读取之后的数据为：");
        int temp = 0;
        while ((temp = push.read()) != -1) {    // 读取内容
            if (temp == '.') {    // 判断是否读取到了“.”
                push.unread(temp);    // 放回到缓冲区之中
                temp = push.read();    // 再读一遍
                System.out.print("（退回" + (char) temp + "）");
            } else {
                System.out.print((char) temp);    // 输出内容
            }
        }
    }
}
