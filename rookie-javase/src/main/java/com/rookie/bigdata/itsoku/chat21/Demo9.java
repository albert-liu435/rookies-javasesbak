package com.rookie.bigdata.itsoku.chat21;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 跟着阿里p7学并发，微信公众号：javacode2018
 */
public class Demo9 {
    static Unsafe unsafe;

    static {
        //获取Unsafe对象
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class C1 {
        private String name;

        private C1() {
            System.out.println("C1 default constructor!");
        }

        private C1(String name) {
            this.name = name;
            System.out.println("C1 有参 constructor!");
        }
    }

    public static void main(String[] args) throws InstantiationException {
        System.out.println(unsafe.allocateInstance(C1.class));
    }
}