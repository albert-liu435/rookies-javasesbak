package com.java.util.concurrent.volatiles;

/**
 * @Classname VolatileDemo1
 * @Description TODO
 * @Author rookie
 * @Date 2022/3/10 15:21
 * @Version 1.0
 */
public class VolatileDemo1 {

    //当flag不是用volatile关键字修饰的时候 该程序不会退出
    public static volatile boolean flag = true;


    public static class taskThread extends Thread {

        public int i;

        public taskThread(String name) {
            super(name);
        }

        @Override
        public void run() {

            System.out.println(this.getName() + " 线程执行开始");

            while (flag) {
                ;
//                System.out.println("循环次数为 " + (i++))
            }
            System.out.println(this.getName() + " 线程执行结束");

        }
    }


    public static void main(String[] args) throws InterruptedException {
        new taskThread("task1").start();
        Thread.sleep(1000);
        flag = false;

    }


}
