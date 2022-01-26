package com.java.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname UDPServer
 * @Description TODO
 * @Author rookie
 * @Date 2022/1/25 11:55
 * @Version 1.0
 */
public class UDPServer  implements Runnable{

    private DatagramSocket socket;
    private DatagramPacket packet;

    public UDPServer(DatagramSocket socket, DatagramPacket packet) {
        this.socket = socket;
        this.packet = packet;

    }

    public static void main(String[] args) throws IOException {
        AtomicInteger numThreads = new AtomicInteger(0);
        DatagramSocket socket = new DatagramSocket(5000);
        while (true) {
            byte[] buf = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            Thread thread = new Thread(new UDPServer(socket, packet));
            thread.start();
            numThreads.incrementAndGet();
        }
    }

    @Override
    public void run() {
        String message = new String(packet.getData(), 0,
                packet.getData().length);
        int port = packet.getPort();
        InetAddress address = packet.getAddress();
        System.out.println("get a message from address:" + address + " port："
                + port + " message:" + message);
        String respose = "服务器已成功收到消息";
        DatagramPacket resPacket = new DatagramPacket(respose.getBytes(),
                respose.getBytes().length, address, port);
        try {
            socket.send(resPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
