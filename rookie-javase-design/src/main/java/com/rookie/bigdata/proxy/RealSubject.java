package com.rookie.bigdata.proxy;

/**
 * @ClassName RealSubject
 * @Description RealSubject
 * @Author rookie
 * @Date 2020/6/19 14:46
 * @Version 1.0
 */
public class RealSubject implements Subject {
    public void Request() {
        System.out.println("访问真实主题方法...");
    }
}
