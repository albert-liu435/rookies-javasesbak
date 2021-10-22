package com.rookie.bigdata.lang.thread;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/3/20 21:36
 * 1、sleep是线程方法，wait是Object方法
 * 2、sleep不释放lock,wait会释放
 * 3、sleep不依赖同步方法，wait需要
 * 4、sleep不需要被唤醒，wait需要被唤醒
 */
public class SleepAndWait {

    private static final Object lock=new Object();

    public static void main(String[] args) throws Exception{
//        Stream.of("线程1","线程2").forEach(n->new Thread(n){
//            @Override
//            public void run() {
//                try {
//                    SleepAndWait.sleep1();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start());
//        Stream.of("线程1","线程2").forEach(n->new Thread(n){
//            @Override
//            public void run() {
//                try {
//                    SleepAndWait.wait1();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start());

//        Stream.of("线程1","线程2").forEach(n->new Thread(n){
//            @Override
//            public void run() {
//                try {
//                    SleepAndWait.sleep2();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start());
//        Stream.of("线程1","线程2").forEach(n->new Thread(n){
//            @Override
//            public void run() {
//                try {
//                    SleepAndWait.wait2();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start());

        SleepAndWait sleepAndWait=new SleepAndWait();
        new Thread(){
            @Override
            public void run() {
                try {
                    sleepAndWait.twait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                try {
                    sleepAndWait.tnotifyWait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();


    }

    private static void sleep1() throws InterruptedException {
        synchronized (lock){
            System.out.println(Thread.currentThread().getName()+"正在执行");
            Thread.sleep(10_000);
            System.out.println(Thread.currentThread().getName()+"休眠结束");
        }
    }


    private static void wait1()throws InterruptedException{
        synchronized (lock){
            System.out.println(Thread.currentThread().getName()+"正在执行");
            lock.wait(10_000);
            System.out.println(Thread.currentThread().getName()+"wait结束");
        }
    }

    private static void sleep2() throws InterruptedException {

            System.out.println(Thread.currentThread().getName()+"正在执行");
            Thread.sleep(10_000);
            System.out.println(Thread.currentThread().getName()+"休眠结束");

    }


    private static void wait2()throws InterruptedException{

            System.out.println(Thread.currentThread().getName()+"正在执行");
            lock.wait(10_000);
            System.out.println(Thread.currentThread().getName()+"wait结束");

    }

    public  void twait() throws InterruptedException {
        synchronized (lock){
            System.out.println("我一直在等待");
           lock.wait();
            System.out.println("wait被唤醒啦");
        }
    }

    public   void tnotifyWait() throws InterruptedException {
        synchronized (lock){
            Thread.sleep(10_000);
            lock.notify();
            System.out.println("休眠10秒钟唤醒wait");
        }
    }

}
