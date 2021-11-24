package com.rookie.bigdata.util.concurrent.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Classname Demo1
 * @Description TODO
 * @Author rookie
 * @Date 2021/11/18 15:58
 * @Version 1.0
 */
public class Demo1 {

    static Unsafe unsafe;
    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        System.out.println(unsafe);
    }
}
