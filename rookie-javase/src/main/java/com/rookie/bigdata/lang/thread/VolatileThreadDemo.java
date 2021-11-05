package com.rookie.bigdata.lang.thread;

/**
 * @Classname VolatileThreadDemo
 * @Description http://www.itsoku.com/course/1/7
 * @Author rookie
 * @Date 2021/11/2 12:00
 * @Version 1.0
 */
public class VolatileThreadDemo {

    //volatile关键字是为了解决可见性的问题的，在线程A修改了被volatitle修饰的值后，其他线程能够马上的看到变化后的值
    public static volatile boolean flag = true;

    public static class T1 extends Thread {
        public T1(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println("线程" + this.getName() + " in");
            while (flag) {
                ;
            }
            System.out.println("线程" + this.getName() + "停止了");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new T1("t1").start();
        //休眠1秒
        Thread.sleep(1000);
        //将flag置为false
        flag = false;
    }


}
