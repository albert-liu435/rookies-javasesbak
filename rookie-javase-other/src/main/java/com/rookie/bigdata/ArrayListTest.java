package com.rookie.bigdata;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ArrayListTest
 * @Description ArrayListTest
 * @Author
 * @Date 2020/4/29 9:40
 * @Version 1.0
 */
public class ArrayListTest {

    public static void main(String[] args) {
        List<String> list=new ArrayList<>();

        for(int i=1;i<10;i++){
            list.add("S"+i);
        }

        for (String s : list) {
            System.out.println(s);
        }

//        ArrayListTest arrayListTest=new ArrayListTest();
//        arrayListTest.method1("zhanagsan");


//        new Thread(()->{
//            System.out.println("线程一");
//        },"线程一").start();
//
//        new Thread(()->{
//            System.out.println("线程二");
//        },"线程二").start();
//
//        new Thread(()->{
//            System.out.println("线程三");
//        },"线程三").start();


    }

    public void method1(String s){
        System.out.println("method1"+s);

        method2(s);
    }

    private void method2(String s) {

        System.out.println("method2"+s);
    }

}
