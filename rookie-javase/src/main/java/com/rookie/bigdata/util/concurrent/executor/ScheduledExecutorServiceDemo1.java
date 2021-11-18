package com.rookie.bigdata.util.concurrent.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Classname ScheduledExecutorServiceDemo1
 * @Description TODO
 * @Author rookie
 * @Date 2021/11/18 15:01
 * @Version 1.0
 */
public class ScheduledExecutorServiceDemo1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(System.currentTimeMillis());
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        scheduledExecutorService.schedule(() -> {
            System.out.println(System.currentTimeMillis() + "开始执行");
            //模拟任务耗时
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(System.currentTimeMillis() + "执行结束");
        }, 2, TimeUnit.SECONDS);
    }
}
