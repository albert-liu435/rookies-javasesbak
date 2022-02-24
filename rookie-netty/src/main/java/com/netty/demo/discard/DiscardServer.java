package com.netty.demo.discard;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Classname DiscardServer
 * @Description TODO
 * @Author rookie
 * @Date 2022/2/23 15:48
 * @Version 1.0
 */
public class DiscardServer {

    int port;


    public DiscardServer(int port) {
        this.port=port;
    }


    public void run()throws Exception{
        //第一个经常被叫做‘boss’，用来接收进来的连接。第二个经常被叫做‘worker’，用来处理已经
        //被接收的连接，一旦‘boss’接收到连接，就会把连接信息注册到‘worker’上。

        //用来接受进来的连接
        EventLoopGroup bossGroup = new NioEventLoopGroup(); // (1)
        //用来处理已经被接受的连接
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap(); // (2)
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class) // (3)
                    .childHandler(new ChannelInitializer<SocketChannel>() { // (4)
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {

                            // 添加ChannelHandler到ChannelPipeline
                            ch.pipeline().addLast(new DiscardServerHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)          // (5)
                    .childOption(ChannelOption.SO_KEEPALIVE, true); // (6)

            // 绑定端口，开始接收进来的连接
            ChannelFuture f = b.bind(port).sync(); // (7)

            System.out.println("DiscardServer已启动，端口：" + port);

            // 等待服务器  socket 关闭 。
            // 在这个例子中，这不会发生，但你可以优雅地关闭你的服务器。
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }

    }


    public static void main(String[] args) throws Exception{
        int port=8080;
        if(args.length>0){
            port=Integer.parseInt(args[0]);
        }

        new DiscardServer(port).run();
    }
}
