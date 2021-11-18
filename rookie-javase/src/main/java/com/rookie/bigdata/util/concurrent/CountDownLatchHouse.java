package com.rookie.bigdata.util.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @Classname CountDownLatchHouse
 * @Description TODO
 * @Author rookie
 * @Date 2021/11/16 17:25
 * @Version 1.0
 */
public class CountDownLatchHouse {


    private static CountDownLatch countDownLatch = new CountDownLatch(20);

    static class TeacherThread extends Thread{
        @Override
        public void run() {
            System.out.println("学校老是在等待学生进入教师，总共有" + countDownLatch.getCount() + "个人上课");
            try {
                //Boss等待
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("所有人都已经到齐，开始上课");
        }
    }

    //
    static class StudentThread  extends Thread{



        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "进入教室");
            // count - 1
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args){
        //Boss线程启动
        new TeacherThread().start();

        for(long i = 0,j = countDownLatch.getCount() ; i < j ; i++){
            new StudentThread().start();
        }
    }
}



