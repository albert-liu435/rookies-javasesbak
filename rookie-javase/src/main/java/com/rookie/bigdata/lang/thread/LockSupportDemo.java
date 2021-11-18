package com.rookie.bigdata.lang.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @Classname LockSupportDemo
 * @Description TODO
 * @Author rookie
 * @Date 2021/11/12 14:51
 * @Version 1.0
 */
public class LockSupportDemo {


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName() + " start!");
            LockSupport.park();
            System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName() + " 被唤醒!");
        });
        t1.setName("t1");
        t1.start();
        //休眠5秒
        TimeUnit.SECONDS.sleep(5);
        LockSupport.unpark(t1);
        System.out.println(System.currentTimeMillis() + ",LockSupport.unpark();执行完毕");
    }


//    public static void main(String[] args) throws InterruptedException {
//        Thread t1 = new Thread(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(5);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName() + " start!");
//            LockSupport.park();
//            System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName() + " 被唤醒!");
//        });
//        t1.setName("t1");
//        t1.start();
//        //休眠1秒
//        TimeUnit.SECONDS.sleep(1);
//        LockSupport.unpark(t1);
//        System.out.println(System.currentTimeMillis() + ",LockSupport.unpark();执行完毕");
//    }


//    public static void main(String[] args) throws InterruptedException {
//        Thread t1 = new Thread(() -> {
//            System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName() + " start!");
//            System.out.println(Thread.currentThread().getName() + ",park()之前中断标志：" + Thread.currentThread().isInterrupted());
//            LockSupport.park();
//            System.out.println(Thread.currentThread().getName() + ",park()之后中断标志：" + Thread.currentThread().isInterrupted());
//            System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName() + " 被唤醒!");
//        });
//        t1.setName("t1");
//        t1.start();
//        //休眠5秒
//        TimeUnit.SECONDS.sleep(5);
//        t1.interrupt();
//    }


//    static class BlockerDemo {
//    }
//    public static void main(String[] args) throws InterruptedException {
//        Thread t1 = new Thread(() -> {
//            LockSupport.park();
//        });
//        t1.setName("t1");
//        t1.start();
//        Thread t2 = new Thread(() -> {
//            LockSupport.park(new BlockerDemo());
//        });
//        t2.setName("t2");
//        t2.start();
//    }




}
