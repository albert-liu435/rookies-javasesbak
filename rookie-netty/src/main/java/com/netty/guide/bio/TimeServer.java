package com.netty.guide.bio;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Classname TimeServer
 * @Description TODO
 * @Author rookie
 * @Date 2022/2/23 9:42
 * @Version 1.0
 */
public class TimeServer {

    public static void main(String[] args) throws Exception{

        int port=8080;
        ServerSocket server=new ServerSocket(port);
        System.out.println("The time server is start in port: "+port);
        while (true){
            Socket accept = server.accept();

            new Thread(new TimeServerHandler(accept)).start();
        }


    }
}
