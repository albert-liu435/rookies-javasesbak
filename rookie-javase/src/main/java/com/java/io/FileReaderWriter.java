package com.java.io;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @Classname FileReaderWriter
 * @Description TODO
 * @Author rookie
 * @Date 2022/2/15 14:55
 * @Version 1.0
 */
public class FileReaderWriter {

    @Test
    public void test1() throws Exception {

        char[] buffer = new char[2048];

        FileReader fr = new FileReader(new File("C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\java\\com\\java\\io\\test1.txt"));

        FileWriter fw = new FileWriter(new File(
                "C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\java\\com\\java\\io\\test3.txt"));
        int len;
        while ((len = fr.read(buffer)) != -1) {
            fw.write(buffer, 0, len);
        }
        fw.flush();

        fw.close();
        fr.close();

        System.out.println("复制完成");
    }
}
