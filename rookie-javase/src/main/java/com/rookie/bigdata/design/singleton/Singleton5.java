package com.rookie.bigdata.design.singleton;

/**
 * @ClassName Singleton5
 * @Description 使用双重校验锁，线程安全
 * @Author rookie
 * @Date 2020/4/15 12:43
 * @Version 1.0
 */
public class Singleton5 {
    private volatile static Singleton5 singleton5 = null;

    private Singleton5() {

    }

    public static Singleton5 getSingleton5() {
        if (singleton5 == null) {
            synchronized (Singleton5.class) {
                if (singleton5 == null) {
                    singleton5 = new Singleton5();
                }
            }
        }
        return singleton5;
    }
}
