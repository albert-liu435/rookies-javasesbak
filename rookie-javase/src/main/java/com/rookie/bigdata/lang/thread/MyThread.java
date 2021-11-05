package com.rookie.bigdata.lang.thread;


import java.util.concurrent.TimeUnit;

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

//    public static void main(String[] args) {
//        MyThread thread1 = new MyThread("thread1");
//        thread1.start();
//
//        MyThread thread2 = new MyThread("thread2");
//        thread2.start();
//
//    }


    public static void main(String[] args) throws Exception {


        Thread thread1 = new Thread() {
            @Override
            public void run() {
                System.out.println("start");
                boolean flag = true;
                while (flag) {
                    ;
                }
                System.out.println("end");
            }
        };
        thread1.setName("thread1");
        thread1.start();
        //当前线程休眠1秒
        TimeUnit.SECONDS.sleep(1);
        //关闭线程thread1
        thread1.stop();
        //输出线程thread1的状态
        System.out.println(thread1.getState());
        //当前线程休眠1秒
        TimeUnit.SECONDS.sleep(1);
        //输出线程thread1的状态
        System.out.println(thread1.getState());
    }


}
