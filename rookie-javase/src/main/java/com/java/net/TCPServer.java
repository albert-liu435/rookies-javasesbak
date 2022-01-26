package com.java.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @Classname TCPServer
 * @Description TODO
 * @Author rookie
 * @Date 2022/1/25 11:40
 * @Version 1.0
 */
public class TCPServer implements Runnable {
    private Socket socket;

    public TCPServer() {
    }

    public TCPServer(Socket socket) {
        this.socket = socket;
    }

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(8001);

        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(new TCPServer(socket)).start();
        }


    }


    @Override
    public void run() {
         byte[] buffer = new byte[1024];

        try {
        String hostAddress = socket.getInetAddress().getHostAddress();
        int port=socket.getPort();

            OutputStream outputStream=socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();


            while (true){
                if(socket.isClosed())
                    return;

                int len= inputStream.read(buffer);
                if(len !=-1){
                    System.out.println("接受到的消息为：" +new String(buffer,0,len));
                    outputStream.write("消息接受成功".getBytes(StandardCharsets.UTF_8));
                }




            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
