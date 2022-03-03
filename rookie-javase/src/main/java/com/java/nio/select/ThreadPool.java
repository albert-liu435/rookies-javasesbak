package com.java.nio.select;

/**
 * @Classname ThreadPool
 * @Description TODO
 * @Author rookie
 * @Date 2022/2/24 17:51
 * @Version 1.0
 */

import java.util.LinkedList;
import java.util.List;

/**
 * A very simple thread pool class. The pool size is set at construction
 * time and remains fixed. Threads are cycled through a FIFO idle queue.
 */
public class ThreadPool {
    List idle = new LinkedList();

    ThreadPool(int poolSize) {
        // Fill up the pool with worker threads
        for (int i = 0; i < poolSize; i++) {
            WorkerThread thread = new WorkerThread(this);
            // Set thread name for debugging. Start it.
            thread.setName("Worker" + (i + 1));
            thread.start();
            idle.add(thread);
        }
    }

    /**
     * Find an idle worker thread, if any. Could return null.
     */
    WorkerThread getWorker() {
        WorkerThread worker = null;
        synchronized (idle) {
            if (idle.size() > 0) {
                worker = (WorkerThread) idle.remove(0);
            }
        }
        return (worker);
    }

    /**
     * Called by the worker thread to return itself to the idle pool.
     */
    void returnWorker(WorkerThread worker) {
        synchronized (idle) {
            idle.add(worker);
        }
    }
}
