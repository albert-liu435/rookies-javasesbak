package com.java.nio.select;


import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

public class WorkerThread extends Thread {
    private ByteBuffer buffer = ByteBuffer.allocate(1024);
    private ThreadPool pool;
    private SelectionKey key;

    WorkerThread(ThreadPool pool) {
        this.pool = pool;
    }
    // Loop forever waiting for work to do

    public synchronized void run() {
        System.out.println(this.getName() + " is ready");
        while (true) {
            try { // Sleep and release object lock
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace(); // Clear interrupt status
                this.interrupted();
            }
            if (key == null) {
                continue; // just in case }
            }
            System.out.println(this.getName() + " has been awakened");
            try {
                drainChannel(key);
            } catch (Exception e) {
                System.out.println("Caught '" + e + "' closing channel");
                // Close channel and nudge selector
                try {
                    key.channel().close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                key.selector().wakeup();
            }
            key = null;// Done. Ready for more. Return to pool
            this.pool.returnWorker(this);
        }
    }

    /**
     * Called to initiate a unit of work by this worker thread on the * provided SelectionKey object. This method is synchronized, as is the * run( ) method, so only one key can be serviced at a given time. * Before waking the worker thread, and before returning to the main * selection loop, this key's interest set is updated to remove OP_READ. * This will cause the selector to ignore read-readiness for this * channel while the worker thread is servicing it.
     */
    synchronized void serviceChannel(SelectionKey key) {
        this.key = key;
        key.interestOps(key.interestOps() & (~SelectionKey.OP_READ));
        this.notify(); // Awaken the thread }
    }

    void drainChannel(SelectionKey key) throws Exception {
        SocketChannel channel = (SocketChannel) key.channel();
        int count;
        buffer.clear();
        // Empty buffer
        // Loop while data is available; channel is nonblocking
        while ((count = channel.read(buffer)) > 0) {
            buffer.flip();
            // make buffer readable
            // Send the data; may not go all at once
            while (buffer.hasRemaining()) {
                channel.write(buffer);
            }// WARNING: the above loop is evil. // See comments in superclass.
            buffer.clear(); // Empty buffer
        }
        if (count < 0) { // Close channel on EOF; invalidates the key
            channel.close();
            return;
        }// Resume interest in OP_READ
        key.interestOps(key.interestOps() | SelectionKey.OP_READ); // Cycle the selector so this key is active again
        key.selector().wakeup();
    }
}
