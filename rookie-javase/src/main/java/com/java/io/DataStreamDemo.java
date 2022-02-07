package com.java.io;

import org.junit.Test;

import java.io.*;

/**
 * @Classname DataStreamDemo
 * @Description TODO
 * @Author rookie
 * @Date 2022/2/7 14:45
 * @Version 1.0
 */
public class DataStreamDemo {


    @Test
    public void test1() throws Exception {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(
                new File("C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\java\\com\\java\\io\\test1.txt")));

        DataInputStream dis = new DataInputStream(new FileInputStream(
                new File("C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\java\\com\\java\\io\\test1.txt")));
        dos.writeInt(1);
        dos.writeBoolean(true);
        dos.writeUTF("Hello World");
        dos.flush();
        int tempInt = dis.readInt();
        boolean tempBoolean = dis.readBoolean();
        String tempUTF = dis.readUTF();
        System.out.println(tempInt + " : " + tempBoolean + " : " + tempUTF);

    }

    @Test
    public void test2() throws Exception {


        DataInputStream dis = new DataInputStream(new FileInputStream(
                new File("C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\java\\com\\java\\io\\test1.txt")));


        char c = dis.readChar();
        System.out.println(c);


        System.out.println((char) (('a' << 8) | ('b' & 0xff)));
    }

    @Test
    public void test3() throws Exception {
        int data;
        PushbackInputStream pis = new PushbackInputStream(
                new FileInputStream(new File("C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\java\\com\\java\\io\\test1.txt")));
        PrintStream ps = new PrintStream(System.out);
        while ((data = pis.read()) != -1) {
            if (data == '1') {
                pis.unread(data);
                System.out.println("\r\nunread data :" + (char) data);
                pis.read();
            }
            ps.write(data);
        }

    }


}
