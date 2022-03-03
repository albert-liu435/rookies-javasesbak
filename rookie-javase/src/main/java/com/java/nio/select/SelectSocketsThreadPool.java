package com.java.nio.select;

/**
 * @Classname SelectSocketsThreadPool
 * @Description TODO
 * @Author rookie
 * @Date 2022/2/24 17:48
 * @Version 1.0
 */

import java.nio.channels.SelectionKey;

/**
 * Specialization of the SelectSockets class which uses a thread pool to service *
 * channels. The thread pool is an ad-hoc implementation quicky lashed togther *
 * in a few hours for demonstration purposes. It's definitely not production *
 * quality. * *
 *
 * @author Ron Hitchens (ron@ronsoft.com)
 */
public class SelectSocketsThreadPool extends SelectSockets {
    private static final int MAX_THREADS = 5;
    private ThreadPool pool = new ThreadPool(MAX_THREADS);

    // -------------------------------------------------------------
    public static void main(String[] argv) throws Exception {
       // new SelectSocketsThreadPool().go(argv);
    }
    // -------------------------------------------------------------

    /**
     * Sample data handler method for a channel with data ready to read. This
     * method is invoked from the go( ) method in the parent class. This handler
     * delegates to a worker thread in a thread pool to service the channel,
     * then returns immediately.
     *
     * @param key A SelectionKey object representing a channel determined by the
     *            selector to be ready for reading. If the channel returns an
     *            EOF condition, it is closed here, which automatically
     *            invalidates the associated key. The selector will then
     *            de-register the channel on the next select call.
     */
    protected void readDataFromSocket(SelectionKey key) throws Exception {
        WorkerThread worker = pool.getWorker();
        if (worker == null) {
            // No threads available. Do nothing. The selection
            // loop will keep calling this method until a
            // thread becomes available. This design could
            // be improved.
            return;
        }
        // Invoking this wakes up the worker thread, then
        worker.serviceChannel(key);
    }


}
