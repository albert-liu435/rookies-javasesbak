package com.java.nio.channels;

import org.junit.Test;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * @Classname DatagramChannelDemo
 * @Description TODO
 * @Author rookie
 * @Date 2022/2/22 16:42
 * @Version 1.0
 */
public class DatagramChannelDemo {


    @Test
    public void testUDP() throws Exception {
        DatagramChannel channel = DatagramChannel.open();
        channel.socket().bind(new InetSocketAddress(9999));

        ByteBuffer buffer = ByteBuffer.allocate(48);

        byte b[];
        while (true) {
            buffer.clear();
            // 接受客户端发送数据
            SocketAddress socketAddress = channel.receive(buffer);

            if (socketAddress != null) {
                int position = buffer.position();
                b = new byte[position];
                buffer.flip();
                for (int i = 0; i < position; ++i) {
                    b[i] = buffer.get();
                }
                System.out.println("receive remote " + socketAddress.toString() + ":" + new String(b, "UTF-8"));
                //接收到消息后给发送方回应

                String message = "I has receive your message";
                ByteBuffer buffer1 = ByteBuffer.allocate(1024);
                buffer1.put(message.getBytes("UTF-8"));
                buffer1.flip();
                channel.send(buffer1, socketAddress);

            }
        }


    }


}
