package com.rookie.bigdata.util.function;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * @Classname ConsumerTestMain
 * @Description TODO
 * @Author rookie
 * @Date 2021/10/25 13:45
 * @Version 1.0
 */
public class ConsumerTestMain {


    @Test
    public void test1() {

        //lambda表达式实例
        Consumer<String> consumer = (s) -> {
            System.out.println(s);
        };
        consumer.accept("hello consumer");

        //接口实现方法
        Consumer<String> stringConsumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        stringConsumer.accept("hello impl Consumer");


        Consumer<Integer> consumer1 = integer -> System.out.println(integer + 2);

        Consumer<Integer> consumer2 = integer -> System.out.println(integer + 3);

        Consumer<Integer> integerConsumer = consumer2.andThen(consumer1);
        //先打印出6,后再打印出5
        integerConsumer.accept(3);


    }
}
