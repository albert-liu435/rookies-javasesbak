package com.rookie.bigdata.nio.pipe;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * @Classname PipeExample
 * @Description TODO
 * @Author rookie
 * @Date 2022/1/24 11:30
 * @Version 1.0
 */
public class PipeExample {
    public static void main(String[] args) throws IOException {
        // The Pipe is created
        Pipe pipe = Pipe.open();
        // For accessing the pipe sink channel
        Pipe.SinkChannel skChannel = pipe.sink();
        String td = "Data is successfully sent for checking the java NIO Channel Pipe.";
        ByteBuffer bb = ByteBuffer.allocate(512);
        bb.clear();
        bb.put(td.getBytes());
        bb.flip();
        // write the data into a sink channel.
        while (bb.hasRemaining()) {
            skChannel.write(bb);
        }
        // For accessing the pipe source channel
        Pipe.SourceChannel sourceChannel = pipe.source();
        bb = ByteBuffer.allocate(512);
        // The data is write to the console
        while (sourceChannel.read(bb) > 0) {
            bb.flip();

            while (bb.hasRemaining()) {
                char TestData = (char) bb.get();
                System.out.print(TestData);
            }
            bb.clear();
        }
    }
}//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/java_nio/java-nio-pipe.html


