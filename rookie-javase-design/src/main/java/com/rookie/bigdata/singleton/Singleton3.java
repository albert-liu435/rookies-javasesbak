package com.rookie.bigdata.singleton;

/**
 * @ClassName Singleton3
 * @Description 饿汉式  线程不安全，最好不要这样写
 * @Author rookie
 * @Date 2020/4/15 12:40
 * @Version 1.0
 */
public class Singleton3 {
    private static Singleton3 singleton3 = null;

    private Singleton3() {

    }

    public static Singleton3 getSingleton3() {
        if (singleton3 == null) {
            singleton3 = new Singleton3();
        }
        return singleton3;
    }
}
