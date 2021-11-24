package com.rookie.bigdata.lang.thread;

/**
 * @Classname T02_yield
 * @Description https://note.dolyw.com/java/03-Java-Concurrent-1-Thread.html#_2-yield
 * @Author rookie
 * @Date 2021/11/23 10:16
 * @Version 1.0
 */
public class T02_yield {
    private static class CreateThread implements Runnable {

        @Override
        public void run() {
            // CreateThread线程循环打印
            for (int i = 0; i < 50; i++) {
                System.out.println("CreateThread3");
            }
        }

    }

    public static void main(String[] args) {
        Thread thread = new Thread(new CreateThread());
        // 启动线程
        thread.start();
        // 写法
        Thread.yield();
        // 主线程循环打印
        for (int i = 0; i < 50; i++) {
            System.out.println("Main3");
        }
    }

    /**
     * JAVA中可以通过让当前线程睡眠一段时间的方式
     * 方法一：通过线程的sleep方法
     * Thread.sleep(1000);
     * Thread.currentThread().sleep(1000);
     * 上面两种没区别，参数1000是以毫秒为单位，即这语句可以让程序等待1秒
     * 方法二：TimeUnit类里的sleep方法
     * java.util.concurrent.TimeUnit;这个类里封装着
     * TimeUnit.DAYS.sleep(1); //天
     * TimeUnit.HOURS.sleep(1); //小时
     * TimeUnit.MINUTES.sleep(1); //分
     * TimeUnit.SECONDS.sleep(1); //秒
     * TimeUnit.MILLISECONDS.sleep(1000); //毫秒
     * TimeUnit.MICROSECONDS.sleep(1000); //微妙
     * TimeUnit.NANOSECONDS.sleep(1000); //纳秒
     * TimeUnit类提供的方法，底层调用的也是Thread类的sleep方法，只是在上层根据时间单位进行封装
     */

}
