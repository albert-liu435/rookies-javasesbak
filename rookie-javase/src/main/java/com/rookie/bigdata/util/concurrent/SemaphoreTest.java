package com.rookie.bigdata.util.concurrent;

import java.util.concurrent.Semaphore;

/**
 * @Classname SemaphoreTest
 * @Description TODO
 * @Author rookie
 * @Date 2021/11/17 18:20
 * @Version 1.0
 */
public class SemaphoreTest {


    static class Parking{
        //信号量
        private Semaphore semaphore;

        Parking(int count){
            semaphore = new Semaphore(count);
        }

        public void park(){
            //用于标识信号量是否获取成功，否则有可能导致许可数量凭空增加
            boolean flag=false;
            try {
                //获取信号量
                semaphore.acquire();
                flag=true;
                long time = (long) (Math.random() * 10);
                System.out.println(Thread.currentThread().getName() + "进入停车场，停车" + time + "秒..." );
                Thread.sleep(time);
                System.out.println(Thread.currentThread().getName() + "开出停车场...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {

                if(flag){
                    semaphore.release();
                }


            }
        }
    }

    static class Car extends Thread {
        Parking parking ;

        Car(Parking parking){
            this.parking = parking;
        }

        @Override
        public void run() {
            parking.park();     //进入停车场
        }
    }

    public static void main(String[] args){
        Parking parking = new Parking(3);

        for(int i = 0 ; i < 5 ; i++){
            new Car(parking).start();
        }
    }
}