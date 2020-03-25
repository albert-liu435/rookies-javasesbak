package com.rookie.bigdata.threadlocal;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/3/19 21:23
 */
public class MyRunnable implements Runnable {

    private static ThreadLocal<String> threadLocal=new ThreadLocal<>();
    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("执行 " + i + name);
            try {

                threadLocal.set(Thread.currentThread().getName());
                System.out.println(threadLocal.get());

                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyRunnable runnable1 = new MyRunnable("runnable1");
        Thread thread1 = new Thread(runnable1);
        thread1.start();

        MyRunnable runnable2 = new MyRunnable("runnable2");
        Thread thread2 = new Thread(runnable2);
        thread2.start();


    }

}
