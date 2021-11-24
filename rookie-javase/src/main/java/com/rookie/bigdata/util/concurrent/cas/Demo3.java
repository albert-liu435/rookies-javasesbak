package com.rookie.bigdata.util.concurrent.cas;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Classname Demo1
 * @Description http://www.itsoku.com/course/1/21
 *
 * 需求：我们开发了一个网站，需要对访问量进行统计，用户每次发一次请求，访问量+1，如何实现呢？
 * <p>
 * 下面我们来模仿有100个人同时访问，并且每个人对咱们的网站发起10次请求，最后总访问次数应该是1000次。实现访问如下。
 * @Author rookie
 * @Date 2021/11/18 15:36
 * @Version 1.0
 */
public class Demo3 {
    //访问次数
    volatile static int count = 0;
    //模拟访问一次
    public static void request() throws InterruptedException {
        //模拟耗时5毫秒
        TimeUnit.MILLISECONDS.sleep(5);
        int expectCount;
        do {
            expectCount = getCount();
        } while (!compareAndSwap(expectCount, expectCount + 1));
    }
    /**
     * 获取count当前的值
     *
     * @return
     */
    public static int getCount() {
        return count;
    }
    /**
     * @param expectCount 期望count的值
     * @param newCount    需要给count赋的新值
     * @return
     */
    public static synchronized boolean compareAndSwap(int expectCount, int newCount) {
        //判断count当前值是否和期望的expectCount一样，如果一样将newCount赋值给count
        if (getCount() == expectCount) {
            count = newCount;
            return true;
        }
       // System.out.println("false");
        return false;
    }
    public static void main(String[] args) throws InterruptedException {
        long starTime = System.currentTimeMillis();
        int threadSize = 100;
        CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        for (int i = 0; i < threadSize; i++) {
            Thread thread = new Thread(() -> {
                try {
                    for (int j = 0; j < 10; j++) {
                        request();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
            thread.start();
        }
        countDownLatch.await();
        long endTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "，耗时：" + (endTime - starTime) + ",count=" + count);
    }
}
