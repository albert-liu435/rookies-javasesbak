package com.rookie.bigdata.singleton;

/**
 * @ClassName Singleton4
 * @Description 饿汉式 线程安全，但是在多线程环境下效率并不高
 * @Author rookie
 * @Date 2020/4/15 12:41
 * @Version 1.0
 */
public class Singleton4 {
    private static Singleton4 singleton4 = null;

    private Singleton4() {

    }

    public static synchronized Singleton4 getSingleton4() {
        if (singleton4 == null) {
            singleton4 = new Singleton4();
        }
        return singleton4;
    }
}
