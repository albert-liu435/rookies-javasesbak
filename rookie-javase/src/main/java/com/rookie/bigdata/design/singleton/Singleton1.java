package com.rookie.bigdata.design.singleton;

/**
 * @ClassName Singleton1
 * @Description 懒汉式  线程安全，在类装载的时候实例化对象，避免线程同步的问题
 * @Author rookie
 * @Date 2020/4/15 12:38
 * @Version 1.0
 */
public class Singleton1 {
    private final static Singleton1 SINGLETON_1 = new Singleton1();

    private Singleton1() {

    }

    public static Singleton1 getSingleton1() {
        return SINGLETON_1;
    }
}
