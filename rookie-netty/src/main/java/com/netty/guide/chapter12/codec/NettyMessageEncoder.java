package com.netty.guide.chapter12.codec;

import com.netty.guide.chapter12.struct.NettyMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @Classname NettyMessageEncoder
 * @Description TODO
 * @Author rookie
 * @Date 2022/3/7 15:46
 * @Version 1.0
 */
public class NettyMessageEncoder extends MessageToByteEncoder<NettyMessage> {
    @Override
    protected void encode(ChannelHandlerContext ctx, NettyMessage msg, ByteBuf out) throws Exception {

    }
}
