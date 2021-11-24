package com.rookie.bigdata.util.concurrent.queue;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Classname Demo3
 * @Description TODO
 * @Author rookie
 * @Date 2021/11/18 16:30
 * @Version 1.0
 */
public class Demo3 {

    static SynchronousQueue<String> queue = new SynchronousQueue<>();
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            try {
                long starTime = System.currentTimeMillis();
                queue.put("java高并发系列，路人甲Java!");
                long endTime = System.currentTimeMillis();
                System.out.println(String.format("[%s,%s,take耗时:%s],%s", starTime, endTime, (endTime - starTime), Thread.currentThread().getName()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        //休眠5秒之后，从队列中take一个元素
        TimeUnit.SECONDS.sleep(5);
        System.out.println(System.currentTimeMillis() + "调用take获取并移除元素," + queue.take());
    }
}
