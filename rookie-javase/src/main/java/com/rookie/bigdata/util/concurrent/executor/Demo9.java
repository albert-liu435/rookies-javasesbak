package com.rookie.bigdata.util.concurrent.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @Classname Demo9
 * @Description TODO
 * @Author rookie
 * @Date 2021/11/18 15:12
 * @Version 1.0
 */
public class Demo9 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(()->{
            System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName()+",start!");
            TimeUnit.SECONDS.sleep(5);
            System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName()+",end!");
            return 10;
        });
        System.out.println(System.currentTimeMillis()+","+Thread.currentThread().getName());
        new Thread(futureTask).start();
        System.out.println(System.currentTimeMillis()+","+Thread.currentThread().getName());
        System.out.println(System.currentTimeMillis()+","+Thread.currentThread().getName()+",结果:"+futureTask.get());
    }
}
