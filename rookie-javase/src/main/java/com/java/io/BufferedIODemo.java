package com.java.io;

import org.junit.Test;

import java.io.*;
import java.util.Random;

/**
 * @Classname BufferedIODemo
 * @Description TODO
 * @Author rookie
 * @Date 2022/1/27 11:32
 * @Version 1.0
 */
public class BufferedIODemo {


    @Test
    public void test1() throws Exception{

        BufferedInputStream bufferedInputStream=
                new BufferedInputStream(new FileInputStream("C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\java\\com\\java\\io\\SequenceInputDemo.java"),10);

        byte[] buffer = new byte[1024];

        int len;
        while ( (len = bufferedInputStream.read(buffer)) != -1) {
            System.out.print(new String(buffer));
            System.out.flush();
        }
        System.out.flush();
    }


    @Test
    public void test2()throws Exception{
        byte[] buffer = new byte[1024];
        try (BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream(new File("C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\java\\com\\java\\io\\SequenceInputDemo.java")));
             BufferedOutputStream bos = new BufferedOutputStream(
                     new FileOutputStream(new File(
                             "C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\java\\com\\java\\io\\testcopy1.txt")))) {
            int len;
            while ( (len = bis.read(buffer)) != -1) {
                bos.write(buffer,0,len);
            }
            System.out.println("copying file has been finished..");
        }

    }



    @Test
    public void test3(){
         final Random random = new Random();

         for(int i=0;i<100;i++){
             System.out.println(random.nextLong());
         }




    }

    @Test
    public void testBufferedIO(){

    }

}
