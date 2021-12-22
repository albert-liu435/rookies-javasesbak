package com.java.nio.buffer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Classname BufferedReaderDemo
 * @Description BufferedReader从testout.txt文件中读取行的简单示例：
 * @Author rookie
 * @Date 2021/12/20 11:20
 * @Version 1.0
 */
public class BufferedReaderDemo {

    public static void main(String[] args) {
        Path file = null;
        BufferedReader bufferedReader = null;
        String relativelyPath = System.getProperty("user.dir");
        try {
            //file = Paths.get(relativelyPath + "/testout.txt");
            file = Paths.get("C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\java\\com\\java\\nio\\channels\\ChannelDemo.java");
            InputStream inputStream = Files.newInputStream(file);

            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            System.out.println("Reading the Line of testout.txt file: \n" + bufferedReader.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/java_nio/java-nio-buffers.html



}
