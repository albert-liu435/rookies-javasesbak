package com.tomcat.net.socket;

import java.io.*;
import java.net.Socket;

/**
 * @Classname SocketMainTest1
 * @Description TODO
 * @Author rookie
 * @Date 2021/12/13 10:02
 * @Version 1.0
 */
public class SocketMainTest1 {

    public static void main(String[] args) throws IOException, InterruptedException {

        Socket socket = new Socket("127.0.0.1", 8080);

        OutputStream os = socket.getOutputStream();
        boolean autoflush = true;

        PrintWriter out = new PrintWriter(socket.getOutputStream(), autoflush);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        //发送一个http请求到应用web服务器
        out.println("GET /index.jsp HTTP/1.1");
        out.println("Host: localhost:8080");
        out.println("Connection: Clase");
        out.println();
        //读取响应
// read the response
        boolean loop = true;
        StringBuffer sb = new StringBuffer(8096);
        while (loop) {
            if (in.ready()) {
                int i = 0;
                while (i != -1) {
                    i = in.read();
                    sb.append((char) i);
                }
                loop = false;
            }
            Thread.currentThread().sleep(50);
        }

// display the response to the out console
        System.out.println(sb.toString());
        socket.close();

    }
}
