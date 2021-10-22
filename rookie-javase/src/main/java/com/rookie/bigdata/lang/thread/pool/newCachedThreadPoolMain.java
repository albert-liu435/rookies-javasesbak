package com.rookie.bigdata.lang.thread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/3/19 23:23
 */
public class newCachedThreadPoolMain {

    public static void main(String[] args) throws Exception{

        //ExecutorService executorService = Executors.newCachedThreadPool();
        //ExecutorService executorService=Executors.newFixedThreadPool(2, Executors.defaultThreadFactory());
        //ExecutorService executorService=Executors.newSingleThreadExecutor();

        //new MyRunnable("thread");
//        for (int i = 0; i <= 100; i++) {
//            executorService.submit(new MyRunnable("thread" + i));
//        }
//
//        Thread.sleep(10000);
//        executorService.shutdown();

        ScheduledExecutorService scheduledExecutorService=Executors.newScheduledThreadPool(2);

        scheduledExecutorService.schedule(new MyRunnable("thread"),10, TimeUnit.SECONDS);

    }


    static class MyRunnable implements Runnable {
        private String name;

        public MyRunnable(String name) {
            this.name = name;
        }


        @Override
        public void run() {

            for (int i = 0; i <= 100; i++) {

                System.out.println(Thread.currentThread().getName() + name + ":" + i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            System.out.println("结束");
        }
    }


}
