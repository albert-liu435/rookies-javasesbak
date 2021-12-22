package com.java.nio.channels;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/**
 * @Classname TransferDemo
 * @Description 从4个不同文件读取文件内容的简单示例，并将它们的组合输出写入第五个文件：
 * @Author rookie
 * @Date 2021/12/20 11:43
 * @Version 1.0
 */
public class TransferDemo {
    public static void main(String[] argv) throws Exception {
        String relativelyPath = System.getProperty("user.dir");
        // Path of Input files
        String[] iF = new String[] { relativelyPath + "/input1.txt", relativelyPath + "/input2.txt",
                relativelyPath + "/input3.txt", relativelyPath + "/input4.txt" };
        // Path of Output file and contents will be written in this file
        String oF = relativelyPath + "/combine_output.txt";
        // Acquired the channel for output file
        FileOutputStream output = new FileOutputStream(new File(oF));
        WritableByteChannel targetChannel = output.getChannel();
        for (int j = 0; j < iF.length; j++) {
            // Get the channel for input files
            FileInputStream input = new FileInputStream(iF[j]);
            FileChannel inputChannel = input.getChannel();

            // The data is tranfer from input channel to output channel
            inputChannel.transferTo(0, inputChannel.size(), targetChannel);

            // close an input channel
            inputChannel.close();
            input.close();
        }
        // close the target channel
        targetChannel.close();
        output.close();
        System.out.println("All jobs done...");
    }//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/java_nio/data-transfer-between-channels.html





}
