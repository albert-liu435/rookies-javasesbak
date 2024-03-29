package com.rookie.bigdata.util.concurrent.queue;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Classname Demo2
 * @Description TODO
 * @Author rookie
 * @Date 2021/11/18 16:28
 * @Version 1.0
 */
public class Demo2 {

    //推送信息封装
    static class Msg implements Comparable<Msg> {
        //优先级，越小优先级越高
        private int priority;
        //推送的信息
        private String msg;
        public Msg(int priority, String msg) {
            this.priority = priority;
            this.msg = msg;
        }
        @Override
        public int compareTo(Msg o) {
            return Integer.compare(this.priority, o.priority);
        }
        @Override
        public String toString() {
            return "Msg{" +
                    "priority=" + priority +
                    ", msg='" + msg + '\'' +
                    '}';
        }
    }
    //推送队列
    static PriorityBlockingQueue<Msg> pushQueue = new PriorityBlockingQueue<Msg>();
    static {
        //启动一个线程做真实推送
        new Thread(() -> {
            while (true) {
                Msg msg;
                try {
                    long starTime = System.currentTimeMillis();
                    //获取一条推送消息，此方法会进行阻塞，直到返回结果
                    msg = pushQueue.take();
                    //模拟推送耗时
                    TimeUnit.MILLISECONDS.sleep(100);
                    long endTime = System.currentTimeMillis();
                    System.out.println(String.format("[%s,%s,take耗时:%s],%s,发送消息:%s", starTime, endTime, (endTime - starTime), Thread.currentThread().getName(), msg));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    //推送消息，需要发送推送消息的调用该方法，会将推送信息先加入推送队列
    public static void pushMsg(int priority, String msg) throws InterruptedException {
        pushQueue.put(new Msg(priority, msg));
    }
    public static void main(String[] args) throws InterruptedException {
        for (int i = 5; i >= 1; i--) {
            String msg = "一起来学java高并发,第" + i + "天";
            Demo2.pushMsg(i, msg);
        }
    }
}
