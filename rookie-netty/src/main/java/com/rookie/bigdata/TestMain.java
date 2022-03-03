package com.rookie.bigdata;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname TestMain
 * @Description TODO
 * @Author rookie
 * @Date 2022/3/1 17:16
 * @Version 1.0
 */
public class TestMain {

    public static void main(String[] args) {
        AtomicInteger idx = new AtomicInteger();
        System.out.println(idx.getAndIncrement() & 1);
        System.out.println(idx.getAndIncrement()& 1);

        System.out.println(idx.getAndIncrement()& 1);

        System.out.println(idx.getAndIncrement()& 1);


        System.out.println(1 << 4);

    }
}
