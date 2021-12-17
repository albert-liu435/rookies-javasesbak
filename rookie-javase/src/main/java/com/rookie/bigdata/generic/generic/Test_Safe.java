package com.rookie.bigdata.generic.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Test_Safe
 * @Description TODO
 * @Author rookie
 * @Date 2021/12/2 14:02
 * @Version 1.0
 */
public class Test_Safe {

    public static void main(String[] args) {
        test();
    }

    private static void test() {
        List arrayList = new ArrayList();
        arrayList.add("aaaa");
        arrayList.add(100);

        for (int i = 0; i < arrayList.size(); i++) {
            String s = (String) arrayList.get(i);
            System.out.println(s);
        }
    }


    //报错
    //aaaa
    //Exception in thread "main" java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
    //	at com.rookie.bigdata.generic.generic.Test_Safe.test(Test_Safe.java:25)
    //	at com.rookie.bigdata.generic.generic.Test_Safe.main(Test_Safe.java:16)
}
