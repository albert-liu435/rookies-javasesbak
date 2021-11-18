package com.rookie.bigdata.lang.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname ConditionDemo
 * @Description 利用Conditio进行线程的等待与唤醒
 * @Author rookie
 * @Date 2021/11/15 14:14
 * @Version 1.0
 */
public class ConditionDemo {

    static ReentrantLock lock = new ReentrantLock();
    //利用
    static Condition condition = lock.newCondition();

    public static void main(String[] args)  throws Exception{
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName() + " start!");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName() + " 被唤醒!");
            } finally {
                lock.unlock();
            }
        });
        t1.setName("t1");
        t1.start();
        //休眠5秒
        TimeUnit.SECONDS.sleep(5);
        lock.lock();
        try {
            condition.signal();
        } finally {
            lock.unlock();
        }
    }
}
