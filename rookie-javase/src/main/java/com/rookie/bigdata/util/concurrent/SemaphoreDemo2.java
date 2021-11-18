package com.rookie.bigdata.util.concurrent;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Classname SemaphoreDemo1
 * @Description 门卫（Semaphore）有点呆，司机进去的时候给了钥匙，出来的时候不归还，门卫也不会说什么。最终结果就是其他车辆都无法进入了。
 * @Author rookie
 * @Date 2021/11/18 10:02
 * @Version 1.0
 */
public class SemaphoreDemo2 {

    static Semaphore semaphore = new Semaphore(2);

    public static class T extends Thread {
        public T(String name) {
            super(name);
        }

        @Override
        public void run() {
            Thread thread = Thread.currentThread();
            try {
                semaphore.acquire();
                System.out.println(System.currentTimeMillis() + "," + thread.getName() + ",获取许可!");
                TimeUnit.SECONDS.sleep(3);
                System.out.println(System.currentTimeMillis() + "," + thread.getName() + ",运行结束!");
                System.out.println(System.currentTimeMillis() + "," + thread.getName() + ",当前可用许可数量:" + semaphore.availablePermits());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new T("t-" + i).start();
        }
    }
}
