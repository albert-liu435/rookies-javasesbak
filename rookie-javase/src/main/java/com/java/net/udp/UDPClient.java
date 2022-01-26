package com.java.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Classname UDPClient
 * @Description TODO
 * @Author rookie
 * @Date 2022/1/25 11:53
 * @Version 1.0
 */
public class UDPClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        String message = "Hello World!";
        byte[] buffer = message.getBytes();
        InetAddress address = InetAddress.getByName("127.0.0.1");
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length,
                address, 8002);
        socket.send(packet);
        while (true) {
            byte[] buf = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(buf, buf.length);
            socket.receive(receivePacket);
            String response = new String(receivePacket.getData(), 0,
                    receivePacket.getData().length);
            if (response != null) {
                System.out.println("服务端收到消息为：" + response);
                socket.close();
                break;
            }
        }
    }
}
