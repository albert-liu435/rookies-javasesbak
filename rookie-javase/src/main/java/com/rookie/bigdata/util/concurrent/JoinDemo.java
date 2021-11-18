package com.rookie.bigdata.util.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @Classname JoinDemo
 * @Description TODO
 * @Author rookie
 * @Date 2021/11/16 14:25
 * @Version 1.0
 */
public class JoinDemo {

    public static class T extends Thread {
        //休眠时间（秒）
        int sleepSeconds;

        public T(String name, int sleepSeconds) {
            super(name);
            this.sleepSeconds = sleepSeconds;
        }

        @Override
        public void run() {
            Thread ct = Thread.currentThread();
            long startTime = System.currentTimeMillis();
            System.out.println(startTime + "," + ct.getName() + ",开始处理!");
            try {
                //模拟耗时操作，休眠sleepSeconds秒
                TimeUnit.SECONDS.sleep(this.sleepSeconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long endTime = System.currentTimeMillis();
            System.out.println(endTime + "," + ct.getName() + ",处理完毕,耗时:" + (endTime - startTime));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long starTime = System.currentTimeMillis();
        T t1 = new T("解析sheet1线程", 2);
        t1.start();
        T t2 = new T("解析sheet2线程", 5);
        t2.start();

        TimeUnit.SECONDS.sleep(1000);
        t1.join();
        t2.join();
        long endTime = System.currentTimeMillis();
        System.out.println("总耗时:" + (endTime - starTime));
    }

}
