package com.netty.guide.chapter3;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * @Classname ChildChannelHandler
 * @Description TODO
 * @Author rookie
 * @Date 2022/3/3 15:41
 * @Version 1.0
 */
public class ChildChannelHandler extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast(new TimeServerHandler());
    }
}
