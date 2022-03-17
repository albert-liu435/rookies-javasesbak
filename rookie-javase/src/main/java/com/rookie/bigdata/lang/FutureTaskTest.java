package com.rookie.bigdata.lang;

import java.util.concurrent.*;

/**
 * @Classname FutureTaskTest
 * @Description TODO
 * @Author rookie
 * @Date 2022/3/10 9:55
 * @Version 1.0
 */
public class FutureTaskTest {


    private final ConcurrentMap<Object, Future<String>> taskCache = new ConcurrentHashMap<>();

    private String executionTask(final String taskName) throws Exception{

        while (true) {
            Future<String> future = taskCache.get(taskName);
            if (future == null) {
                Callable<String> task = new Callable<String>() {
                    @Override
                    public String call() throws Exception {

                        return taskName;
                    }
                };

                FutureTask<String> futureTask = new FutureTask<>(task);
                future = taskCache.putIfAbsent(taskName, futureTask);
                if (future == null) {
                    future = futureTask;
                    futureTask.run();
                }


            }

            return future.get();
        }
    }
}
