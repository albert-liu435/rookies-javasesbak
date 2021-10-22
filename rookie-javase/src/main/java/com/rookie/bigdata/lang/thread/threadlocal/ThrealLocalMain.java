package com.rookie.bigdata.lang.thread.threadlocal;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/3/24 23:50
 */
public class ThrealLocalMain {

    private static ThreadLocal<String> threadLocal=new ThreadLocal<>();

    public static void main(String[] args) {
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                //设置线程本地变量的值
                threadLocal.set("zhangsan");

                hello("张三媳妇");
                System.out.println(":"+threadLocal.get());

            }
        });
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("lisi");

                hello("李四媳妇");
                System.out.println(":"+threadLocal.get());

            }
        });

        thread1.start();
        thread2.start();







    }

    public static void hello(String name){
        //打印当前线程本地内存中本地变量的值
        System.out.println(name+": "+threadLocal.get());
        //可以把这个注释掉
        threadLocal.remove();
    }

}
