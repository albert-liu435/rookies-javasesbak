package com.rookie.bigdata.lang.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Classname ThreadDaemon
 * @Description TODO
 * @Author rookie
 * @Date 2021/11/3 15:55
 * @Version 1.0
 */
public class ThreadDaemon {


    public static class T1 extends Thread {
        public T1(String name) {
            super(name);
        }
        @Override
        public void run() {
            System.out.println(this.getName() + "开始执行," + (this.isDaemon() ? "我是守护线程" : "我是用户线程"));
            while (true) ;
        }
    }



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

//    public static void main(String[] args) {
////        T1 t1 = new T1("子线程1");
////        t1.start();
////        System.out.println("主线程结束");
//
//
//        T1 t1 = new T1("子线程1");
//        t1.setDaemon(true);
//        t1.start();
//        System.out.println("主线程结束");
//    }

}
