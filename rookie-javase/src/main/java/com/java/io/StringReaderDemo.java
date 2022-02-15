package com.java.io;

import org.junit.Test;

import java.io.StringReader;
import java.io.StringWriter;

/**
 * @Classname StringReaderDemo
 * @Description TODO
 * @Author rookie
 * @Date 2022/2/8 15:41
 * @Version 1.0
 */
public class StringReaderDemo {


    @Test
    public  void StringReader() throws Exception{
        String str = "今天外面真的冷啊果然应该点外的";

            //1. 构造方法  传入字符串
            StringReader stringReader = new StringReader(str);

            //2. int read() 读操作，读取一个字符   （将String字符串操作 适配成 Reader字符操作 对外提供服务）
//            int read=stringReader.read();
//            System.out.println((char) read);

            //int read(char cbuf[]) throws IOException   批量读
            char[] chars = new char[3];
            int read1=stringReader.read(chars);
            System.out.println(new String(chars,0,3));

            //int read(char cbuf[], int off, int len)   批量读
//            char[] chars1 = new char[3];
//            int read2=stringReader.read(chars1,0,3);
//            System.out.println(new String(chars1,0,3));

            // boolean ready()  判断数据源是否存在
            stringReader.ready();


            //3. markSupported()  是否支持标记    FileInputStream和FileReader 都不支持
            System.out.println("是否支持标记："+stringReader.markSupported());

            // void mark(int readAheadLimit) throws IOException  标记
            //TODO: 测试发现并未从标记位置读，依旧是接着原先next所指位置读数据
            stringReader.mark(5);
            char[] chars2=new char[3];
            int read3 = stringReader.read(chars2,0,3);
            System.out.println("mark标记后读三个数："+new String(chars2,0,3));
            //TODO：mark使用并不相当于指针 --> 和RandomAccessFile的seek操作不是一个性质

            // void reset() throws IOException   重置指针
            // 单独使用 reset() 方法
            stringReader.reset();
            char[] chars3=new char[3];
            int read4 = stringReader.read(chars3,0,3);
            System.out.println("单独使用reset()方法:"+new String(chars3,0,3));

            // mark()方法 与 reset()方法 结合使用
            stringReader.mark(2);
            stringReader.reset();
            char[] chars4=new char[3];
            int read5 = stringReader.read(chars4,0,3);
            System.out.println("mark()与reset()结合使用:"+new String(chars4,0,3));


            // long skip(long ns) throws IOException   跳过流中指定数量的字符 返回跳过的字符数
            stringReader.skip(2);     //正数往前跳
//            stringReader.skip(-2);    //负数往后跳
            char[] chars5=new char[3];
            int read6 = stringReader.read(chars5,0,3);
            System.out.println("向前跳两个字符："+new String(chars5,0,3));

            //关闭流
            stringReader.close();

    }




    @Test
    public void test1() throws Exception{
        char cbuf[]=new char[5];
        String str="abcdefghijklmn";
        StringReader reader=new StringReader(str);
        int read = reader.read(cbuf, 2, 3);
        //此时cbuf数组中的值为{'\u0000','\u0000','a','b','c'}
        System.out.println(read);

        //此时读取的字符为d
        int read1 = reader.read();
        System.out.println((char) read1);


    }



    @Test
    public void test2()throws Exception{

        StringWriter stringWriter=new StringWriter();
        stringWriter.write('a');
        System.out.println(stringWriter.getBuffer().toString());


        char [] c = {'b','c','d','e','f'};
        stringWriter.write(c,1,3);
        System.out.println(stringWriter.getBuffer().toString());

        stringWriter.write("hello java");
        System.out.println(stringWriter.getBuffer().toString());


    }


}
