package com.java.io;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

/**
 * @Classname ByteArrayDemo
 * @Description TODO
 * @Author rookie
 * @Date 2022/1/26 15:38
 * @Version 1.0
 */
public class ByteArrayDemo {

    public static final int LENGTH = 3;
//    public static final byte[] datas = { 0x61, 0x62, 0x63, 0x64, 0x65, 0x66,
//            0x67, 0x68, 0x69, 0x6A, 0x6B, 0x6C, 0x6D, 0x6E, 0x6F, 0x70, 0x71,
//            0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 0x78, 0x79, 0x7A };

    public static final byte[] datas = {97, 98, 99, 100, 101, 102,
            103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113,
            114, 115, 116, 117, 118, 119, 120, 121, 122};

    public static void main(String[] args) {


        System.out.println("源数据为：" + new String(datas, 0, datas.length));
        new ByteArrayDemo().test();

        String s = new String(datas, 0, datas.length);

//        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
//        for (byte aByte : bytes) {
//            System.out.println(aByte);
//        }

        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            System.out.println((byte) aChar);
            // System.out.println(Integer.toHexString(aChar));
        }


    }

    private void test() {
        ByteArrayInputStream bais = new ByteArrayInputStream(datas);
        int len;
        //将数据源中的数据全部读出，并打印，此时pos应该与count想等
        while ((len = bais.read()) != -1) {
            System.out.print((char) len);
        }
        //将pos重置为0
        bais.reset();
        //将pos向后跳跃5个字节
        bais.skip(5);
        //将此处做上标记，下次reset时，pos定位在标记处，这里的参数0无实际意义
        bais.mark(0);
        System.out.println("\r\n" + (char) bais.read());
        bais.skip(10);
        System.out.println((char) bais.read());
        bais.reset();
        System.out.println((char) bais.read());
    }

    @Test
    public void test1() {


        byte[] bytes = {97, 98, 99, 100, 101, 102,
                103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113,
                114, 115, 116, 117, 118, 119, 120, 121, 122};
        System.out.println(new String(datas, 0, datas.length));

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        int len;
        while ((len = byteArrayInputStream.read()) != -1) {
            System.out.println((char) len);
        }
        System.out.println("==================");
        //将pos重置为0
        byteArrayInputStream.reset();
        //将pos向后跳跃5个字节
        byteArrayInputStream.skip(5);
        //将此处做上标记，下次reset时，pos定位在标记处，这里的参数0无实际意义
        byteArrayInputStream.mark(0);
        System.out.println("\r\n" + (char) byteArrayInputStream.read());
        byteArrayInputStream.skip(10);
        System.out.println((char) byteArrayInputStream.read());
        byteArrayInputStream.reset();
        System.out.println((char) byteArrayInputStream.read());


    }

    @Test
    public void test2() throws Exception {
        File file = new File("C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\java\\com\\java\\io\\FileIODemo.java");
        FileInputStream fileInputStream = new FileInputStream(file);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int len;
        while ((len = fileInputStream.read()) != -1) {
            byteArrayOutputStream.write(len);
        }
        String s = byteArrayOutputStream.toString();
        System.out.println(s);
        fileInputStream.close();
        byteArrayOutputStream.close();

    }
}
