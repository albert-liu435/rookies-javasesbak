package com.rookie.bigdata.prototype;

/**
 * @ClassName ShallowClient
 * @Description 在浅克隆中，如果原型对象的成员变量是值类型（八大基本类型，byte,short,int,long,char,double,float,boolean）.那么就直接复制，如果是复杂的类型，（枚举，String,对象）就只复制对应的内存地址
 * @Author liuxili
 * @Date 2020/6/19 11:08
 * @Version 1.0
 */
public class ShallowClient {

    //测试类，客户端
    public static void main(String[] args) {
        ShallowWeeklyLog log_1, log_2;
        log_1 = new ShallowWeeklyLog();    //创建原型对象
        ShallowAttachment attachment = new ShallowAttachment(); //创建附件对象
        log_1.setAttachment(attachment);    //将附件添加到周报种去
        log_2 = log_1.clone();    //克隆周报
        System.out.println("周报是否相同" + (log_1 == log_2));
        System.out.println("附件是否相同" + (log_1.getAttachment() == log_2.getAttachment()));
    }

}
