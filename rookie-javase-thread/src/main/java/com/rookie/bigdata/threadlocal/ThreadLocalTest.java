package com.rookie.bigdata.threadlocal;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/3/25 0:21
 */
public class ThreadLocalTest {
    private static final AtomicInteger nextId = new AtomicInteger(0);

    private static final ThreadLocal<Integer> threadId=new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {

            return nextId.getAndIncrement();
        }
    };
    public static int get() {
        return nextId.get();
    }

    public static void main(String[] args) {
//        Integer integer = threadId.get();
//        System.out.println(integer);
//        System.out.println(get());

        Integer integer = threadId.get();
    }

}
