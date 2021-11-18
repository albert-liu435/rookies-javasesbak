package com.rookie.bigdata.lang.thread;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname ConditionTest
 * @Description https://www.cmsblogs.com/article/1391297860124938240  生产者消费者模型
 * @Author rookie
 * @Date 2021/11/15 14:20
 * @Version 1.0
 */
public class ConditionTest {
    private LinkedList<String> buffer;    //容器
    private int maxSize ;           //容器最大
    private Lock lock;
    private Condition fullCondition;
    private Condition notFullCondition;

    ConditionTest(int maxSize){
        this.maxSize = maxSize;
        buffer = new LinkedList<String>();
        lock = new ReentrantLock();
        fullCondition = lock.newCondition();
        notFullCondition = lock.newCondition();
    }

    public void set(String string) throws InterruptedException {
        lock.lock();    //获取锁
        try {
            while (maxSize == buffer.size()){
                System.out.println("进入等待中");
                notFullCondition.await();       //满了，添加的线程进入等待状态
            }

            buffer.add(string);
            fullCondition.signal();
        } finally {
            lock.unlock();      //记得释放锁
        }
    }

    public String get() throws InterruptedException {
        String string;
        lock.lock();
        try {
            while (buffer.size() == 0){

                fullCondition.await();
            }
            string = buffer.poll();
            notFullCondition.signal();
        } finally {
            lock.unlock();
        }
        return string;
    }


    public static void main(String[] args) throws Exception{

        ConditionTest conditionTest=new ConditionTest(10);




        new Thread(()->{

            for(int i=0;i<100;i++){

                try {
                    conditionTest.set(i+"");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(()->{

            for(int i=0;i<100;i++){

                try {
                    String s = conditionTest.get();
                    System.out.println(s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();





    }

}
