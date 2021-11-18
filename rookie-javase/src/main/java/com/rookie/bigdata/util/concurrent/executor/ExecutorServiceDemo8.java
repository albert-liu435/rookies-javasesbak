package com.rookie.bigdata.util.concurrent.executor;

import java.util.concurrent.*;

/**
 * @Classname ExecutorServiceDemo6
 * @Description TODO
 * @Author rookie
 * @Date 2021/11/18 15:08
 * @Version 1.0
 */
public class ExecutorServiceDemo8 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> result = executorService.submit(() -> {
            System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName()+",start!");
            TimeUnit.SECONDS.sleep(5);
            System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName()+",end!");
            return 10;
        });
        System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName());
        try {
            System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName() + ",结果：" + result.get(3,TimeUnit.SECONDS));
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        executorService.shutdown();




        //ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor()
    }



}
