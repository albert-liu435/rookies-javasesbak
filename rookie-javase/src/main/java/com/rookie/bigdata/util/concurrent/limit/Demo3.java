package com.rookie.bigdata.util.concurrent.limit;


import com.google.common.util.concurrent.RateLimiter;


/**
 * @Classname Demo3
 * @Description TODO
 * @Author rookie
 * @Date 2021/11/18 16:49
 * @Version 1.0
 */
public class Demo3 {

    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = RateLimiter.create(5);//设置QPS为5
        for (int i = 0; i < 10; i++) {
            rateLimiter.acquire();
            System.out.println(System.currentTimeMillis());
        }
        System.out.println("----------");
        //可以随时调整速率，我们将qps调整为10
        rateLimiter.setRate(10);
        for (int i = 0; i < 10; i++) {
            rateLimiter.acquire();
            System.out.println(System.currentTimeMillis());
        }
    }
}
