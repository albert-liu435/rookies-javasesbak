package com.rookie.bigdata.util.concurrent.ThreadPoolExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Classname ThreadPoolExecutorDemo
 * @Description TODO
 * @Author rookie
 * @Date 2021/11/19 11:26
 * @Version 1.0
 */
public class ThreadPoolExecutorDemo {

    public static void main(String[] args) throws InterruptedException {
         ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(3,5,10,TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(10),Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());


//        List<Callable<String>> list=new ArrayList<>();
//        //当i=100的时候，超过队列的数量10，所以会报出 RejectedExecutionException
//        for(int i=0;i<10;i++){
//            list.add(new Callable<String>() {
//                @Override
//                public String call() throws Exception {
//                    System.out.println(Math.random());
//                    return "string";
//                }
//            });
//        }
//        threadPoolExecutor.invokeAll(list);
        //当i=100时，也会报RejectedExecutionException
        for (int i = 0; i < 100; i++) {
            int j = i;
            String taskName = "任务" + j;
            threadPoolExecutor.execute(() -> {
                //模拟任务内部处理耗时
                try {
                    TimeUnit.SECONDS.sleep(j);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + taskName + "处理完毕");
            });
        }
        //关闭线程池
        threadPoolExecutor.shutdown();

    }
}
