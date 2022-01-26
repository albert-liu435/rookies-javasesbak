package com.java.io;

import org.junit.Test;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.Vector;

/**
 * @Classname SequenceInputDemo
 * @Description TODO
 * @Author rookie
 * @Date 2022/1/26 16:58
 * @Version 1.0
 */
public class SequenceInputDemo {


    @Test
    public void test1(){
        Enumeration<String> days;
        Vector<String> dayNames = new Vector<String>();
        dayNames.add("Sunday");
        dayNames.add("Monday");
        dayNames.add("Tuesday");
        dayNames.add("Wednesday");
        dayNames.add("Thursday");
        dayNames.add("Friday");
        dayNames.add("Saturday");
        days = dayNames.elements();
        while (days.hasMoreElements()){
            System.out.println(days.nextElement());
        }
    }
    @Test
    public void test2(){

    }
}
