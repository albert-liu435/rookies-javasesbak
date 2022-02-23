package com.netty.demo.discard;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;


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
        //默默地丢弃收到的数据
        ((ByteBuf) msg).release();
    }
}
