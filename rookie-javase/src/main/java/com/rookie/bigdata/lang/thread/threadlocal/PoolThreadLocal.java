package com.rookie.bigdata.lang.thread.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/3/25 7:47
 */
public class PoolThreadLocal {

    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(3, Executors.defaultThreadFactory());

        executorService.submit(new MyRunnable("thread"));
    }
}
