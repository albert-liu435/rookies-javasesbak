package com.rookie.bigdata.lang.thread;


/**
 * @author rookie
 * @version 1.0
 * @date 2020/3/19 21:16
 */
public class MyThread extends Thread {

    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("执行 " + i + name);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyThread thread1 = new MyThread("thread1");
        thread1.start();

        MyThread thread2 = new MyThread("thread2");
        thread2.start();

    }

}
