package com.rookie.bigdata.lang.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Classname ThreadGroup
 * @Description TODO
 * @Author rookie
 * @Date 2021/11/3 15:14
 * @Version 1.0
 */
public class ThreadGroupDemo {


    public static class R1 implements Runnable {
        @Override
        public void run() {
            System.out.println("threadName:" + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        //创建线程组的时候，可以给其指定一个父线程组，也可以不指定，如果不指定父线程组，则父线程组为当前线程的线程组,
        //这里表示父线程组是main,main的父线程组是system
        ThreadGroup threadGroup = new ThreadGroup("thread-group-1");
        Thread t1 = new Thread(threadGroup, new R1(), "t1");
        Thread t2 = new Thread(threadGroup, new R1(), "t2");
        t1.start();
        t2.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("活动线程数:" + threadGroup.activeCount());
        System.out.println("活动线程组:" + threadGroup.activeGroupCount());
        System.out.println("线程组名称:" + threadGroup.getName());
    }

}
