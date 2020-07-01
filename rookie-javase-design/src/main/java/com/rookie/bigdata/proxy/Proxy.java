package com.rookie.bigdata.proxy;

/**
 * @ClassName Proxy
 * @Description Proxy
 * @Author rookie
 * @Date 2020/6/19 14:47
 * @Version 1.0
 */
public class Proxy implements Subject {
    private RealSubject realSubject;

    public void Request() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        preRequest();
        realSubject.Request();
        postRequest();
    }

    public void preRequest() {
        System.out.println("访问真实主题之前的预处理。");
    }

    public void postRequest() {
        System.out.println("访问真实主题之后的后续处理。");
    }
}
