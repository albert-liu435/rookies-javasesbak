package com.netty.guide.chapter5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Classname EchoServerHandler
 * @Description TODO
 * @Author rookie
 * @Date 2022/2/24 10:18
 * @Version 1.0
 */
@ChannelHandler.Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    int counter = 0;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        String body = (String) msg;
        // 因为分隔符被DelimiterBaseFrameDecoder解码后就丢掉了, 所以需要手动加回去, 然后发送给客户端 才能让客户端正确的解码
        System.out.println("This is " + ++counter + " times receive client : [" + body + "]");
        body += " callback $_";
        ByteBuf echo = Unpooled.copiedBuffer(body.getBytes());
        ctx.writeAndFlush(echo);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();// 发生异常，关闭链路
    }
}

