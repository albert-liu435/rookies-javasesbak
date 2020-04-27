package com.rookie.bigdata.domain;

import java.util.Date;

/**
 * @ClassName FunctionModel
 * @Description FunctionModel
 * @Author liuxili
 * @Date 2020/4/27 17:33
 * @Version 1.0
 */
public class FunctionModel {


    public static void staticConsumer(String message) {
        System.out.println(message);
    }

    public void consumer(String message) {
        System.out.println(message);
    }

    public Date supplier() {
        return new Date();
    }

    public boolean predicate(String message) {
        return message != null && message.startsWith("function");
    }

    public void biConsumer(String m1,String m2) {
        System.out.println(m1 + "," + m2);

    }


    }
