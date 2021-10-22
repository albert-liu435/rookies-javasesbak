package com.rookie.bigdata.lang.annotation;

/**
 * @Classname Person
 * @Description TODO
 * @Author rookie
 * @Date 2021/10/22 16:52
 * @Version 1.0
 */
public class Person {


    @MyAnnotation(value = "lisi")
    public void boy(String name){
        System.out.println("boy name is "+ name);
    }

    @MyAnnotation(value = "zhangsan")
    public void girl(String name){

        System.out.println("girl name is " +name);
    }

}