package com.rookie.bigdata.design.singleton;

/**
 * @ClassName Singleton2
 * @Description 懒汉式  线程安全，在类装载的时候实例化对象，避免线程同步的问题
 * @Author rookie
 * @Date 2020/4/15 12:39
 * @Version 1.0
 */
public class Singleton2 {
    private static Singleton2 singleton2;

    static {
        singleton2 = new Singleton2();
    }

    private Singleton2() {

    }

    public static Singleton2 getSingleton2() {
        return singleton2;
    }
}
