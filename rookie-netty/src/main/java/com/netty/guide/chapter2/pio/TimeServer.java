package com.netty.guide.chapter2.pio;



import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Classname TimeServer
 * @Description TODO
 * @Author rookie
 * @Date 2022/2/23 9:52
 * @Version 1.0
 */
public class TimeServer {
    public static void main(String[] args) throws IOException {
        int port = 8090;
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("The time server is start in port : " + port);
            Socket socket;
            TimeServerHandlerExecutePool singleExecutor = new TimeServerHandlerExecutePool(
                    50, 10000);// 创建IO任务线程池
            while (true) {
                socket = server.accept();
                singleExecutor.execute(new TimeServerHandlers(socket));
            }
        } finally {
            if (server != null) {
                System.out.println("The time server close");
                server.close();
            }
        }
    }
}
