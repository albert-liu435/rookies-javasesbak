package com.rookie.bigdata.lang.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/3/20 0:33
 */
public class ThreadPoolMain {
    public static void main(String[] args) {
        ExecutorService executorService=Executors.newFixedThreadPool(2, Executors.defaultThreadFactory());

        executorService.submit(new MyRunnable("thread"));
    }

    public static volatile int exit=0;
    static class MyRunnable implements Runnable {
        private String name;

        public MyRunnable(String name) {
            this.name = name;
        }


        @Override
        public void run() {
        //使用退出标志退出线程
          while (exit <= 19){
              exit++;
              System.out.println(Thread.currentThread().getName()+": "+exit);
              try {
                  Thread.sleep(1000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }

            System.out.println("结束");
        }
    }

}
