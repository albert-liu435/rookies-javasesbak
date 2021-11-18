package com.rookie.bigdata.util.concurrent;

import java.util.concurrent.CyclicBarrier;

/**
 * @Classname CyclicBarrierTest
 * @Description TODO
 * @Author rookie
 * @Date 2021/11/17 18:15
 * @Version 1.0
 */
public class CyclicBarrierTest {

    private static CyclicBarrier cyclicBarrier;

    static class CyclicBarrierThread extends Thread{
        public void run() {
            System.out.println(Thread.currentThread().getName() + "到了");
            //等待
            try {
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("学生到齐了，开始上课");
            }
        });

        for(int i = 0 ; i < 5 ; i++){
       //     Thread.sleep(1000);
            new CyclicBarrierThread().start();
        }
    }
}
