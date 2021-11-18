package com.rookie.bigdata.util.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @Classname CountDownLatchTest
 * @Description TODO
 * @Author rookie
 * @Date 2021/11/16 17:05
 * @Version 1.0
 */
public class CountDownLatchTest {
    private static CountDownLatch countDownLatch = new CountDownLatch(5);

    /**
     * Boss线程，等待员工到达开会
     */
    static class BossThread extends Thread{
        @Override
        public void run() {
            System.out.println("Boss在会议室等待，总共有" + countDownLatch.getCount() + "个人开会...");
            try {
                //Boss等待
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("所有人都已经到齐了，开会吧...");
        }
    }

    //员工到达会议室
    static class EmpleoyeeThread  extends Thread{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "，到达会议室....");
            //员工到达会议室 count - 1
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args){
        //Boss线程启动
        new BossThread().start();

        for(long i = 0,j = countDownLatch.getCount() ; i < j ; i++){
            new EmpleoyeeThread().start();
        }
    }
}