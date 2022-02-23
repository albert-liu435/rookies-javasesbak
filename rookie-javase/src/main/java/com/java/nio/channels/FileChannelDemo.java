package com.java.nio.channels;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @Classname FileChannel
 * @Description TODO
 * @Author rookie
 * @Date 2022/2/21 17:24
 * @Version 1.0
 */
public class FileChannelDemo {


    @Test
    public void testFileReadNio() throws Exception {
        FileInputStream fileInputStream = new FileInputStream("C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\java\\com\\java\\nio\\file\\FileDemo.java");
        FileChannel channel = fileInputStream.getChannel();


        ByteBuffer allocate = ByteBuffer.allocate(1024);


        while ( channel.read(allocate) != -1) {
            byte[] array = allocate.array();
            String str = new String(array);
            System.out.println(str);

            allocate.clear();
        }

        channel.close();
        fileInputStream.close();
    }


    @Test
    public void testFileWriteNio()throws Exception{

        FileOutputStream fileOutputStream=new FileOutputStream("C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\resources\\a.txt");
        FileChannel channel = fileOutputStream.getChannel();

        ByteBuffer buffer= Charset.forName("utf8").encode("hello java nio");
        while (channel.write(buffer) !=0){
            System.out.println(buffer.array().length);
        }

        channel.close();
        fileOutputStream.close();
    }



    @Test
    public void testFileReadWriteNio()throws Exception{


        FileInputStream fileInputStream = new FileInputStream("C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\java\\com\\java\\nio\\file\\FileDemo.java");
        FileChannel readChannel = fileInputStream.getChannel();


        FileOutputStream fileOutputStream=new FileOutputStream("C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\resources\\a.txt");
        FileChannel writeChannel = fileOutputStream.getChannel();

        ByteBuffer allocate = ByteBuffer.allocate(1024);

        while (readChannel.read(allocate) !=-1){
            //进行翻转
            allocate.flip();
//            while (writeChannel.write(allocate) !=0){
//
//            }
            writeChannel.write(allocate);

            allocate.clear();
        }

        readChannel.close();
        writeChannel.close();
        fileInputStream.close();
        fileOutputStream.close();
    }





    @Test
    public void testMapFile()throws Exception{


        FileInputStream fileInputStream = new FileInputStream("C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\java\\com\\java\\nio\\file\\FileDemo.java");
        FileChannel readChannel = fileInputStream.getChannel();

        FileOutputStream fileOutputStream=new FileOutputStream("C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\resources\\a.txt");
        FileChannel writeChannel = fileOutputStream.getChannel();

        MappedByteBuffer map = readChannel.map(FileChannel.MapMode.READ_ONLY, 100, 1000);

        writeChannel.write(map);
        readChannel.close();
        writeChannel.close();


      //  System.out.println(map);


    }


    @Test
    public void testTrans()throws Exception{
        FileInputStream fileInputStream = new FileInputStream("C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\java\\com\\java\\nio\\file\\FileDemo.java");
        FileChannel readChannel = fileInputStream.getChannel();

        FileOutputStream fileOutputStream=new FileOutputStream("C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\resources\\a.txt");
        FileChannel writeChannel = fileOutputStream.getChannel();

        readChannel.transferTo(0,readChannel.size(),writeChannel);


        readChannel.close();
        writeChannel.close();
        fileInputStream.close();
        fileOutputStream.close();

    }





    /**
     * 文件空洞
     *
     * @throws Exception
     */
    @Test
    public void testFileTemp() throws Exception {

        //创建一个临时文件，打开并写入，并获取一个FileChannel
        File temp = File.createTempFile("holy", null);

        RandomAccessFile file = new RandomAccessFile(temp, "rw");

        FileChannel channel = file.getChannel();

        //创建缓冲区

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);
        putData(0, byteBuffer, channel);
        putData(5000000, byteBuffer, channel);
        putData(50000, byteBuffer, channel);

        //// Size will report the largest position written, but
        // there are two holes in this file. This file will
        // not consume 5 MB on disk (unless the filesystem is
        //// extremely brain-damaged)

        System.out.println("Wrote temp file '" + temp.getPath() + "', size=" + channel.size());
        channel.close();
        file.close();


    }

    private static void putData(int position, ByteBuffer buffer, FileChannel channel) throws IOException {
        String string = "*<-- location " + position;
        buffer.clear();
        buffer.put(string.getBytes("US-ASCII"));
        buffer.flip();
        channel.position(position);
        channel.write(buffer);
    }


    @Test
    public void testPosition() throws Exception {

        RandomAccessFile randomAccessFile = new RandomAccessFile("C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\java\\com\\java\\nio\\BufferDome.java", "r");

        //设置文件的位置
        randomAccessFile.seek(1000);

        //创建一个Channel
        FileChannel fileChannel = randomAccessFile.getChannel();

        // This will print "1000"
        System.out.println("file pos: " + fileChannel.position());
        // Change the position using the RandomAccessFile object
        randomAccessFile.seek(500);

        // This will print "500"
        System.out.println("file pos: " + fileChannel.position());
        // Change the position using the FileChannel object
        fileChannel.position(200);
        // This will print "200"
        System.out.println("file pos: " + randomAccessFile.getFilePointer());
    }


    private static final String DEMOGRAPHIC = "C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\resources\\blahblah.txt";

    @Test
    public void test1() throws Exception {

        int reps = 10;
        FileOutputStream fos = new FileOutputStream(DEMOGRAPHIC);
        GatheringByteChannel gatherChannel = fos.getChannel();
        // Generate some brilliant marcom, er, repurposed content

        ByteBuffer[] bs = utterBS(reps);
        // Deliver the message to the waiting market
        while (gatherChannel.write(bs) > 0) {
            // Empty body // Loop until write( ) returns zero
        }

        System.out.println("Mindshare paradigms synergized to " + DEMOGRAPHIC);

        fos.close();
    }

    private static String[] col1 = {"Aggregate", "Enable", "Leverage", "Facilitate", "Synergize", "Repurpose", "Strategize", "Reinvent", "Harness"};

    private static String[] col2 = {"cross-platform", "best-of-breed", "frictionless", "ubiquitous", "extensible", "compelling", "mission-critical", "collaborative", "integrated"};

    private static String[] col3 = {"methodologies", "infomediaries", "platforms", "schemas", "mindshare", "paradigms", "functionalities", "web services", "infrastructures"};

    private static String newline = System.getProperty("line.separator");

    private static ByteBuffer[] utterBS(int howMany) throws Exception {
        List list = new LinkedList();
        for (int i = 0; i < howMany; i++) {
            list.add(pickRandom(col1, " "));
            list.add(pickRandom(col2, " "));
            list.add(pickRandom(col3, newline));
        }
        ByteBuffer[] bufs = new ByteBuffer[list.size()];
        list.toArray(bufs);
        return (bufs);
    }

    // The communications director
    private static Random rand = new Random();
    // Pick one, make a buffer to hold it and the suffix, load it with
    // the byte equivalent of the strings (will not work properly for

    // non-Latin characters), then flip the loaded buffer so it's ready // to be drained


    private static ByteBuffer pickRandom(String[] strings, String suffix) throws Exception {
        String string = strings[rand.nextInt(strings.length)];
        int total = string.length() + suffix.length();
        ByteBuffer buf = ByteBuffer.allocate(total);
        buf.put(string.getBytes("US-ASCII"));
        buf.put(suffix.getBytes("US-ASCII"));
        buf.flip();
        return (buf);
    }

}
