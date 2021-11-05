package com.rookie.bigdata.lang.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname SynchronizedDemo
 * @Description TODO
 * @Author rookie
 * @Date 2021/11/3 16:08
 * @Version 1.0
 */
public class SynchronizedDemo {


    static volatile int num = 0;

    //synchronized
    public static  void m1() {
        for (int i = 0; i < 10000; i++) {

//            try {
//                TimeUnit.NANOSECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            num++;
        }
    }
    public static class T1 extends Thread {
        @Override
        public void run() {
            SynchronizedDemo.m1();
        }
    }
    public static void main(String[] args) throws InterruptedException {

        for (int i=0;i<100;i++){
            T1 t1 = new T1();
            T1 t2 = new T1();
            T1 t3 = new T1();
            t1.start();
            t2.start();
            t3.start();
            //等待3个线程结束打印num
            t1.join();
            t2.join();
            t3.join();
            System.out.println(SynchronizedDemo.num);
            SynchronizedDemo.num=0;
            /**
             * 打印结果：
             * 25572
             */
        }

    }
}
