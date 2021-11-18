package com.rookie.bigdata.util.concurrent.executor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname ScheduledExecutorServiceDemo2
 * @Description TODO
 * @Author rookie
 * @Date 2021/11/18 15:03
 * @Version 1.0
 */
public class ScheduledExecutorServiceDemo5 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(System.currentTimeMillis());
        //任务执行计数器
        AtomicInteger count = new AtomicInteger(1);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(() -> {
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
        TimeUnit.SECONDS.sleep(5);
        scheduledFuture.cancel(false);
        TimeUnit.SECONDS.sleep(1);
        System.out.println("任务是否被取消："+scheduledFuture.isCancelled());
        System.out.println("任务是否已完成："+scheduledFuture.isDone());
    }
}
