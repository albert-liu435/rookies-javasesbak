package com.rookie.bigdata.util.concurrent.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname ScheduledExecutorServiceDemo2
 * @Description TODO
 * @Author rookie
 * @Date 2021/11/18 15:03
 * @Version 1.0
 */
public class ScheduledExecutorServiceDemo2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(System.currentTimeMillis());
        //任务执行计数器
        AtomicInteger count = new AtomicInteger(1);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            int currCount = count.getAndIncrement();
            System.out.println(Thread.currentThread().getName());
            System.out.println(System.currentTimeMillis() + "第" + currCount + "次" + "开始执行");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(System.currentTimeMillis() + "第" + currCount + "次" + "执行结束");
        }, 1, 1, TimeUnit.SECONDS);
    }
}
