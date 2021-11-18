package com.rookie.bigdata.lang.thread;

/**
 * @Classname daemonThreadDemo
 * @Description 用户线程不是守护线程，所以会一直运行中
 * @Author rookie
 * @Date 2021/11/12 10:58
 * @Version 1.0
 */
public class daemonThreadDemo {


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
        T1 t1 = new T1("子线程1");
        //当程序中所有的用户线程执行完毕之后，不管守护线程是否结束，系统都会自动退出。
        t1.setDaemon(true);
        t1.start();
        System.out.println("主线程结束");
    }


}
