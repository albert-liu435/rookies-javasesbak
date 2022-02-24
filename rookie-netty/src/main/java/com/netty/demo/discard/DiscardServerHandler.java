package com.netty.demo.discard;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;


/**
 * @Classname DiscardServerHandler
 * @Description TODO
 * @Author rookie
 * @Date 2022/2/23 15:24
 * @Version 1.0
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        //默默地丢弃收到的数据
//        ((ByteBuf) msg).release();


        ByteBuf in = (ByteBuf) msg;
        try {
            while (in.isReadable()) { // (1)

                // 打印消息内容
                System.out.print((char) in.readByte());
                System.out.flush();
            }
        } finally {

            // 释放消息
            ReferenceCountUtil.release(msg); // (2)
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        //出现异常就关闭连接
        cause.printStackTrace();
        ctx.close();
    }
}
