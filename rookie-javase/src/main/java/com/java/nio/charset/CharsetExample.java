package com.java.nio.charset;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/**
 * @Classname CharsetExample
 * @Description TODO
 * @Author rookie
 * @Date 2022/1/24 11:34
 * @Version 1.0
 */
public class CharsetExample {
    public static void main(String[] args) {
        Charset cs = Charset.forName("UTF-8");
        System.out.println(cs.displayName());
        System.out.println(cs.canEncode());
        String st = "Welcome to yiibai.com, it is Charset test Example.";
        // The conversion of byte buffer from given charset to char buffer in
        // unicode
        ByteBuffer bytebuffer = ByteBuffer.wrap(st.getBytes());
        CharBuffer charbuffer = cs.decode(bytebuffer);
        // The converesion of char buffer from unicode to byte buffer in given
        // charset
        ByteBuffer newbytebuffer = cs.encode(charbuffer);
        while (newbytebuffer.hasRemaining()) {
            char ca = (char) newbytebuffer.get();
            System.out.print(ca);
        }
        newbytebuffer.clear();
    }
}//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/java_nio/java-nio-charset.html


