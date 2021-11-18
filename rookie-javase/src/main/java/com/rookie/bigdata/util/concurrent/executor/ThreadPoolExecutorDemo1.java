package com.rookie.bigdata.util.concurrent.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Classname ThreadPoolExecutorDemo1
 * @Description TODO
 * @Author rookie
 * @Date 2021/11/18 14:18
 * @Version 1.0
 */
public class ThreadPoolExecutorDemo1 {

    static ThreadPoolExecutor executor = new ThreadPoolExecutor(3,
            5,
            10,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(10),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int j = i;
            String taskName = "任务" + j;
            executor.execute(() -> {
                //模拟任务内部处理耗时
                try {
                    TimeUnit.SECONDS.sleep(j);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + taskName + "处理完毕");
            });
        }
        //关闭线程池
        executor.shutdown();
    }
}
