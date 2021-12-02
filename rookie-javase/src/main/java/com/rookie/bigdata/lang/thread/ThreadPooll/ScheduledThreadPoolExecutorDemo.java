package com.rookie.bigdata.lang.thread.ThreadPooll;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Classname ScheduledThreadPoolExecutorDemo
 * @Description TODO
 * @Author rookie
 * @Date 2021/11/25 11:43
 * @Version 1.0
 */
public class ScheduledThreadPoolExecutorDemo {

    public static void main(String[] args) {

        Date date = new Date();
        System.out.println(date);

        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor=new ScheduledThreadPoolExecutor(10);


       // scheduledThreadPoolExecutor.sche
        scheduledThreadPoolExecutor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Date date = new Date();
                System.out.println("hello"+ date);
            }
        },10L,10, TimeUnit.SECONDS);

       // scheduledThreadPoolExecutor.scheduleWithFixedDelay()
    }
}
