package com.rookie.bigdata.lang.thread;

/**
 * @Classname SynchronizedDemoTest
 * @Description TODO
 * @Author rookie
 * @Date 2021/11/3 16:50
 * @Version 1.0
 */
public class SynchronizedDemoTest {


    public Object object=new Object();

    //修饰静态方法
    public  synchronized static void print1(){
        System.out.println("hello synchronized print1" );
    }



    public void print2(){
        //自定义代码块
        synchronized (object){
            System.out.println("hello synchronized print2" );
        }
    }


    //修饰普通方法
    public synchronized void print3(){
        System.out.println("hello synchronized print3");
    }


    public static void main(String[] args) {


        SynchronizedDemoTest.print1();

        SynchronizedDemoTest synchronizedDemoTest=new SynchronizedDemoTest();
        synchronizedDemoTest.print2();
        synchronizedDemoTest.print3();


    }


}
