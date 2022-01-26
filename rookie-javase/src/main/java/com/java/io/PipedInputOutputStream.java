package com.java.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.nio.charset.StandardCharsets;

/**
 * @Classname PipedInputOutputStream
 * @Description TODO
 * @Author rookie
 * @Date 2022/1/25 10:55
 * @Version 1.0
 */
public class PipedInputOutputStream {

    public static void main(String[] args) throws Exception {

        PipedInputStream pipedInputStream = new PipedInputStream();
        PipedOutputStream pipedOutputStream = new PipedOutputStream();

        pipedOutputStream.connect(pipedInputStream);


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {


                    for (int i = 0; i < 1000; i++) {

                        try {
                            pipedOutputStream.write((i + "").getBytes(StandardCharsets.UTF_8));

                            System.out.println("输出数数据:" + i);

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }

                }
            }
        });


        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                byte[] temp = new byte[1024];
                try {
                    int len;
                    while ((len = pipedInputStream.read(temp)) != -1) {
                        System.out.println("输入数据为：" + new String(temp, 0, len));
                        Thread.sleep(1000);
                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        thread1.start();

    }
}
