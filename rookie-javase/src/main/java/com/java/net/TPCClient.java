package com.java.net;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Classname TPCClient
 * @Description TODO
 * @Author rookie
 * @Date 2022/1/25 11:40
 * @Version 1.0
 */
public class TPCClient {
    public static void main(String[] args) throws Exception {
        byte[] buffer = new byte[1024];
        Socket socket = new Socket("127.0.0.1", 8001);
        socket.setSoTimeout(2000);

        String message = "Hello World!";
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        int len;
        os.write(message.getBytes());
        while (true) {
            len = is.read(buffer);
            if (len != -1) {
                String response = new String(buffer, 0, len);
                System.out.println("服务器接收的消息为" + response);
                break;
            }
        }
        socket.close();

    }
}
