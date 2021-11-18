package com.rookie.bigdata.lang.thread;

import java.util.concurrent.*;

/**
 * @Classname ExecutorLock
 * @Description
 * @Author rookie
 * @Date 2021/11/2 9:49
 * @Version 1.0
 */
public class ExecutorLock {

    private static ExecutorService single = Executors.newSingleThreadExecutor();
    public static class AnotherCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("in AnotherCallable");
            return "annother success";
        }
    }
    public static class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("in MyCallable");
            Future<String> submit = single.submit(new AnotherCallable());
            return "success:" + submit.get();
        }
    }

    //堆栈信息结合图中的代码，可以看出主线程在32行处于等待中，线程池中的工作线程在25行处于等待中，等待获取结果。由于线程池是一个线程，AnotherCallable得不到执行，而被饿死，最终导致了程序死锁的现象。
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable task = new MyCallable();
        Future<String> submit = single.submit(task);
        System.out.println(submit.get());
        System.out.println("over");
        single.shutdown();
    }
}
