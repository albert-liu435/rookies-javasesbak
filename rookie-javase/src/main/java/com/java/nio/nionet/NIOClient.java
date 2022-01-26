package com.java.nio.nionet;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Classname NIOClient
 * @Description TODO
 * @Author rookie
 * @Date 2022/1/24 10:25
 * @Version 1.0
 */
public class NIOClient {


    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream out = socket.getOutputStream();
        String s = "hello world";
        out.write(s.getBytes());
        out.close();
    }
}
