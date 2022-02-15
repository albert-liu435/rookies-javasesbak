package com.java.io;

import org.junit.Test;
import sun.security.action.GetPropertyAction;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.security.AccessController;

/**
 * @Classname PrintStreamDemo
 * @Description TODO
 * @Author rookie
 * @Date 2022/2/8 10:12
 * @Version 1.0
 */
public class PrintStreamDemo {


    @Test
    public void test1() {
        PrintStream out = System.out;
        out.println("hello java");
        out.println(new Object());
    }


    @Test
    public void test2() throws Exception{
        PrintStream printStream=new PrintStream("C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\java\\com\\java\\io\\test1.txt");

        printStream.println("hello java");
        printStream.println("hello java IO");

    }



    @Test
    public void test3()throws Exception{
        String csn = AccessController.doPrivileged(
                new GetPropertyAction("file.encoding"));
        System.out.println(csn);
    }
}
