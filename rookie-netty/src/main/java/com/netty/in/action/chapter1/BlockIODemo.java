package com.netty.in.action.chapter1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Classname BlockIODemo
 * @Description TODO
 * @Author rookie
 * @Date 2022/2/22 17:45
 * @Version 1.0
 */
public class BlockIODemo {


    public static void main(String[] args) throws Exception {
        //创建一个新的ServerSocket，用于监听指定的端口
        ServerSocket socket = new ServerSocket(9999);
        //调用该方法将阻塞，直到有一个连接建立,返回socket用于客户端和服务端之间进行通信
        Socket accept = socket.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(accept.getInputStream()));

        PrintWriter out = new PrintWriter(accept.getOutputStream(), true);
        String request, response;
        while ((request = in.readLine()) != null) {
            if ("Done".equals(request)) {
                break;
            }
            System.out.println(request);
            response = processRequest(request);
            out.println(response);
        }
    }

    private static String processRequest(String request) {
        return "Processed";
    }

}
