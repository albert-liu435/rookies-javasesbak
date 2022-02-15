package com.rookie.bigdata.nio.charset;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * @Classname CharsetExam
 * @Description TODO
 * @Author rookie
 * @Date 2022/1/24 11:36
 * @Version 1.0
 */
public class CharsetExam {
    public static void main(String[] args) throws CharacterCodingException {
        Charset cs = Charset.forName("UTF-8");
        CharsetDecoder csdecoder = cs.newDecoder();
        CharsetEncoder csencoder = cs.newEncoder();
        String st = "Example of Encode and Decode in Java NIO.";
        ByteBuffer bb = ByteBuffer.wrap(st.getBytes());
        CharBuffer cb = csdecoder.decode(bb);
        ByteBuffer newbb = csencoder.encode(cb);
        while (newbb.hasRemaining()) {
            char ca = (char) newbb.get();
            System.out.print(ca);
        }
        newbb.clear();
    }//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/java_nio/encode-and-decode-in-java-nio.html


}
