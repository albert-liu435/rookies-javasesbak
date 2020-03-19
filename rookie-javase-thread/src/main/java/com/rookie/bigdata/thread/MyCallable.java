package com.rookie.bigdata.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/3/19 21:56
 */
public class MyCallable implements Callable {
    private String name;

    public MyCallable(String name) {
        this.name = name;
    }

    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println("执行 线程" + i + name);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "task";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable=new MyCallable("callabe");
        FutureTask futureTask=new FutureTask(myCallable);
        Thread thread=new Thread(futureTask);
        thread.start();

        System.out.println(futureTask.get());
        System.out.println("执行主线程");

    }

}
