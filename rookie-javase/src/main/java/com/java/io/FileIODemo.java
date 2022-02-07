package com.java.io;

import org.junit.Test;

import java.io.*;

/**
 * @Classname FileIODemo
 * @Description File主要用于对文件系统中的文件进行操作
 * @Author rookie
 * @Date 2022/1/25 10:17
 * @Version 1.0
 */
public class FileIODemo {

//    public static void main(String[] args) {
//        File file=new File("C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\java\\com\\java\\io\\FileIODemo.java");
//        System.out.println(file);
//    }

    @Test
    public void test1() {
        //绝对路径
        File file = new File("C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\java\\com\\java\\io\\FileIODemo.java");

        File file1 = new File("src/main/java/com/java/io/FileIODemo.java");
        System.out.println(file1.getAbsolutePath());
    }

    @Test
    public void test2CreateFile() throws Exception {

        //如果文件不存在,则进行文件创建
        File file = new File("C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\java\\com\\java\\io\\a.java");
        boolean exists = file.exists();
        System.out.println(exists);
        boolean flag = file.createNewFile();
        System.out.println(flag);


        //判断文件夹是否存在,如果不存在则进行文件夹创建
        File file1 = new File("C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\java\\com\\java\\abc");
        boolean exists1 = file1.exists();
        System.out.println(exists1);
        boolean flag1 = file1.mkdir();
        System.out.println(flag1);

        //多级文件夹创建
        File file2 = new File("C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\java\\com\\java\\abc\\abc\\abc\\abc\\abc");
        boolean exists2 = file2.exists();
        System.out.println(exists2);
        boolean flag2 = file2.mkdirs();
        System.out.println(flag2);

    }

    @Test
    public void testDel() throws Exception {
        //如果文件不存在,则进行文件创建
        File file = new File("C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\java\\com\\java\\io\\a.java");
        boolean exists = file.exists();
        System.out.println(exists);
        boolean flag = file.createNewFile();
        System.out.println(flag);
        boolean delete = file.delete();
        System.out.println(delete);
        // file.deleteOnExit();

    }


    @Test
    public void test9() throws Exception {
        byte[] buffer = new byte[2];

        FileInputStream fileInputStream = new FileInputStream("C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\java\\com\\java\\io\\FileIODemo.java");
        int length = 0;


        while ((length =fileInputStream.read(buffer) )!= -1) {
            //System.out.println(new String(buffer,0,length));
            System.out.print(new String(buffer,0,length));
            System.out.flush();

        }


        //        FileOutputStream fileOutputStream=new FileOutputStream("C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\java\\com\\java\\io\\ds.java");
//        while (fileInputStream.read(buffer) !=-1){
//            fileOutputStream.write(buffer);
//        }

        System.out.println("操作完成");

    }


    @Test
    public void test10() throws Exception {
        byte[] buffer = new byte[1024];

        FileInputStream fileInputStream = new FileInputStream("C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\java\\com\\java\\io\\FileIODemo.java");
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\java\\com\\java\\io\\ds.java");
        while (fileInputStream.read(buffer) != -1) {
            fileOutputStream.write(buffer);
        }

        System.out.println("操作完成");

    }


    @Test
    public void test11() throws Exception {
        char[] buffer = new char[1024];


        FileReader fileReader = new FileReader(new File("C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\java\\com\\java\\io\\FileIODemo.java"));
        FileWriter fileWriter = new FileWriter(new File("C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\java\\com\\java\\io\\ds.java"));
        int len;
        while ((len = fileReader.read(buffer)) != -1) {
            fileWriter.write(buffer, 0, len);

        }


        System.out.println("操作完成");

    }


}
