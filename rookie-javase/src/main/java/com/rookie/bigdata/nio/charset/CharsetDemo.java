package com.rookie.bigdata.nio.charset;

/**
 * @Classname CharsetDemo
 * @Description TODO
 * @Author rookie
 * @Date 2022/1/21 16:59
 * @Version 1.0
 */


import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Map;
import java.util.Set;

/**
 * 字符集（Charset）
 * 编码：字符串-->字节数组
 * 解码：字节数组-->字符串
 */

public class CharsetDemo {

    @Test
    public void charSetEncoderAndDecoder() throws CharacterCodingException {
        Charset charset = Charset.forName("UTF-8");
        //1.获取编码器
        CharsetEncoder charsetEncoder = charset.newEncoder();
        //2.获取解码器
        CharsetDecoder charsetDecoder = charset.newDecoder();

        //3.获取需要解码编码的数据
        CharBuffer charBuffer = CharBuffer.allocate(1024);
        charBuffer.put("字符集编码解码");
        charBuffer.flip();

        //4.编码
        ByteBuffer byteBuffer = charsetEncoder.encode(charBuffer);
        System.out.println("编码后：");
        for (int i = 0; i < byteBuffer.limit(); i++) {
            System.out.println(byteBuffer.get());
        }
        //5.解码
        byteBuffer.flip();
        CharBuffer charBuffer1 = charsetDecoder.decode(byteBuffer);
        System.out.println("解码后：");
        System.out.println(charBuffer1.toString());
        System.out.println("指定其他格式解码:");
        Charset charset1 = Charset.forName("GBK");
        byteBuffer.flip();
        CharBuffer charBuffer2 = charset1.decode(byteBuffer);
        System.out.println(charBuffer2.toString());
        //6.获取Charset所支持的字符编码
        Map<String, Charset> map = Charset.availableCharsets();
        Set<Map.Entry<String, Charset>> set = map.entrySet();
        for (Map.Entry<String, Charset> entry : set
        ) {
            System.out.println(entry.getKey() + "=" + entry.getValue().toString());
        }
    }


}

