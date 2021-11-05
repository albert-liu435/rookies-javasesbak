package com.rookie.bigdata.lang.thread;

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
    public static void main(String[] args) {
//        T1 t1 = new T1("子线程1");
//        t1.start();
//        System.out.println("主线程结束");


        T1 t1 = new T1("子线程1");
        t1.setDaemon(true);
        t1.start();
        System.out.println("主线程结束");
    }

}
