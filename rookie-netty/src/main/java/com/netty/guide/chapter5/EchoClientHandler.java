package com.netty.guide.chapter5;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Classname EchoClientHandler
 * @Description TODO
 * @Author rookie
 * @Date 2022/2/24 10:19
 * @Version 1.0
 */
public class EchoClientHandler extends ChannelInboundHandlerAdapter {

    private int counter;

    private static final String ECHO_REQ = "Hi, Lilinfeng. Welcome to Netty.$_";

    /**
     * Creates a client-side handler.
     */
    public EchoClientHandler() {
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        // ByteBuf buf = UnpooledByteBufAllocator.DEFAULT.buffer(ECHO_REQ
        // .getBytes().length);
        // buf.writeBytes(ECHO_REQ.getBytes());
        // 循环发送消息
        for (int i = 0; i < 10; i++) {
            ctx.writeAndFlush(Unpooled.copiedBuffer(ECHO_REQ.getBytes()));
        }
    }

    /**
     * 当服务端回应消息时,该方法被调用, 因为所有过往的消息都会被解码, 所以服务端发回来客户端发送的消息就需要 重新添加分隔符
     * @param ctx
     * @param msg
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("This is " + ++counter + " times receive server : [" + msg + "]");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}