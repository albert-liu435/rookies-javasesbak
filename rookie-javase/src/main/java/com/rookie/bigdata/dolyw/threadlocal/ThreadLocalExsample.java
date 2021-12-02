package com.rookie.bigdata.dolyw.threadlocal;

/**
 * @Classname ThreadLocalExsample
 * @Description TODO
 * @Author rookie
 * @Date 2021/11/29 10:20
 * @Version 1.0
 */
public class ThreadLocalExsample {


    //这种写法不会报空指针，因为已经给了一个默认的初始值
//    public static ThreadLocal<Long> longLocal = new ThreadLocal<Long>(){
//        @Override
//        protected Long initialValue() {
//            return 1L;
//        }
//    };


    public static ThreadLocal<Long> longLocal = new ThreadLocal<Long>();



    public void set() {
        longLocal.set(Thread.currentThread().getId());
    }
    public long getLong() {
        return longLocal.get();
    }
    public static void main(String[] args) {
        ThreadLocalExsample test = new ThreadLocalExsample();
        //注意:没有set之前，直接get，报null异常了
        System.out.println("-------threadLocal value-------" + test.getLong());
    }
}