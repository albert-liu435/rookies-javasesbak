package com.netty.guide.chapter2.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @Classname AcceptCompletionHandler
 * @Description 用来接受通知消息
 * @Author rookie
 * @Date 2022/3/3 15:01
 * @Version 1.0
 */
public class AcceptCompletionHandler implements
        CompletionHandler<AsynchronousSocketChannel, AsyncTimeServerHandler> {

    @Override
    public void completed(AsynchronousSocketChannel result,
                          AsyncTimeServerHandler attachment) {

        //调用asynchronousServerSocketChannel的accept方法后，如果有新的客户端连接接入，系统将回调我们
        //传入的completed方法，表示新的客户端已经接入成功。因为一个asynchronousServerSocketChannel可以
        //接收成千上万个客户端，所以需需要继续调用它的accept方法，接受不其他的客户端连接，最终新城一个循环
        //每当接收一个客户端连接成功之后，再一步去接收新的客户端连接
        attachment.asynchronousServerSocketChannel.accept(attachment, this);
        //服务端接收客户端的请求消息
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        result.read(buffer, buffer, new ReadCompletionHandler(result));
    }

    @Override
    public void failed(Throwable exc, AsyncTimeServerHandler attachment) {
        exc.printStackTrace();
        attachment.latch.countDown();
    }

}
