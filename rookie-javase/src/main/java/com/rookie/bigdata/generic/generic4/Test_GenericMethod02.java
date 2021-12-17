package com.rookie.bigdata.generic.generic4;

/**
 * @Classname Test_GenericMethod02
 * @Description TODO
 * @Author rookie
 * @Date 2021/12/2 14:24
 * @Version 1.0
 */
public class Test_GenericMethod02 {
    public static void main(String[] args) {
        print("123",753,123.12);
    }
    //必须是三个点
    public static <T> void print(T... args) {
        for (T t : args) {
            System.out.println(t);
        }
    }
}