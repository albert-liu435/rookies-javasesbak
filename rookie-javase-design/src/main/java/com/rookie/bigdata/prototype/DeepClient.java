package com.rookie.bigdata.prototype;

/**
 * @ClassName ShallowClient
 * @Description 在JAVA怎么做到深度克隆了？通过序列化（Serialization）等方式来进行深度克隆。这个时候要聊一聊什么是序列化了。简单的讲就是序列化就将对象写到流的一个过程，写到流里面去（就是字节流）就等于复制了对象，但是原来的对象并没有动，只是复制将类型通过流的方式进行读取，然后写到另个内存地址中去！
 * @Author liuxili
 * @Date 2020/6/19 11:08
 * @Version 1.0
 */
public class DeepClient {

    //测试类，客户端
    public static void main(String[] args) throws Exception {
        DeepWeeklyLog log_1, log_2;
        log_1 = new DeepWeeklyLog();    //创建原型对象
        DeepAttachment attachment = new DeepAttachment(); //创建附件对象
        log_1.setAttachment(attachment);    //将附件添加到周报种去
        log_2 = log_1.deepclone();    //克隆周报
        System.out.println("周报是否相同" + (log_1 == log_2));
        System.out.println("附件是否相同" + (log_1.getAttachment() == log_2.getAttachment()));
    }

}
