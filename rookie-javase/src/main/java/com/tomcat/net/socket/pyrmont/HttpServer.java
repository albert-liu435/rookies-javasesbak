package com.tomcat.net.socket.pyrmont;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Classname HttpServer
 * @Description TODO
 * @Author rookie
 * @Date 2021/12/13 10:13
 * @Version 1.0
 */
public class HttpServer {


    /**
     * WEB_ROOT is the directory where our HTML and other files reside.
     * * For this package, WEB_ROOT is the "webroot" directory under the
     * * working directory.
     * * The working directory is the location in the file system * from where the java command was invoked.
     */

    //C:\work\IDEAWorkSpace\rookie-project\haizhilangzigithub\rookies-javases\rookie-javase\src\main\webapp
    public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "rookie-javase\\src\\main\\webapp";//  + "webroot";
    // shutdown command
    private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";
    // the shutdown command received
    private boolean shutdown = false;

    public static void main(String[] args) {
        System.out.println(WEB_ROOT);
        HttpServer server = new HttpServer();
        server.await();
    }

    public void await() {
        ServerSocket serverSocket = null;
        int port = 8080;
        try {
            serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        } // Loop waiting for a request

        while (!shutdown) {
            Socket socket = null;
            InputStream input = null;
            OutputStream output = null;
            try {
                socket = serverSocket.accept();
                input = socket.getInputStream();
                output = socket.getOutputStream(); // create Request object and parse
                Request request = new Request(input);
                request.parse(); // create Response object
                Response response = new Response(output);
                response.setRequest(request);
                response.sendStaticResource();
                // Close the socket
                socket.close(); //check if the previous URI is a shutdown command
                shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }
}
