package com.java.nio.buffer;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Classname BufferedReader
 * @Description TODO
 * @Author rookie
 * @Date 2022/2/16 15:17
 * @Version 1.0
 */
public class BufferedReaderDemo {


    @Test
    public void test1() throws Exception{
        Path file = null;
        BufferedReader bufferedReader = null;

        file = Paths.get("C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\java\\com\\java\\security\\SecurityTest.java");
        InputStream inputStream = Files.newInputStream(file);

        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        System.out.println("Reading the Line of testout.txt file: \n" + bufferedReader.readLine());


    }


}
