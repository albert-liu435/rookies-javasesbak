package com.java.io;

import org.junit.Test;

import java.io.*;

/**
 * @Classname CharArrayDemo
 * @Description TODO
 * @Author rookie
 * @Date 2022/2/8 11:52
 * @Version 1.0
 */
public class CharArrayDemo {




    @Test
    public void test1() throws Exception{

        char [] datas={'a','b','c','d','e','f','g'};
        CharArrayReader charArrayReader=new CharArrayReader(datas,2,2);

        int len;
        //将数据源中的数据全部读出，并打印，此时pos应该与count想等
        while ((len = charArrayReader.read()) != -1) {
            System.out.print((char) len);
        }
    }

    @Test
    public void test2() throws Exception{

        char [] datas={'a','b','c','d','e','f','g'};
        CharArrayReader charArrayReader=new CharArrayReader(datas,2,2);

        int len;
        //将数据源中的数据全部读出，并打印，此时pos应该与count想等
        while ((len = charArrayReader.read()) != -1) {
            System.out.print((char) len);
        }


        //将pos重置为0
        charArrayReader.reset();
        //将pos向后跳跃5个字节
        charArrayReader.skip(5);
        //将此处做上标记，下次reset时，pos定位在标记处，这里的参数0无实际意义
        charArrayReader.mark(0);
        System.out.println("\r\n" +  charArrayReader.read());
        charArrayReader.skip(10);
        System.out.println( charArrayReader.read());
        charArrayReader.reset();
        System.out.println( charArrayReader.read());

    }

    @Test
    public void test3() throws Exception{

        CharArrayWriter charArrayWriter = new CharArrayWriter();
        charArrayWriter.write("Hello JAVA IO CharArrayWriter");
        FileWriter fileWriter = new FileWriter("C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\java\\com\\java\\io\\test2.txt");

        charArrayWriter.writeTo(fileWriter);
        fileWriter.close();
        charArrayWriter.close();

    }

}
