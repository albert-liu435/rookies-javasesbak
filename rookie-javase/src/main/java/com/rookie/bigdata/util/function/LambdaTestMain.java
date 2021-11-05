package com.rookie.bigdata.util.function;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

/**
 * @Classname LambdaTestMain
 * @Description https://github.com/CarpenterLee/JavaLambdaInternals/blob/master/4-Streams%20API(I).md
 * @Author rookie
 * @Date 2021/11/1 15:40
 * @Version 1.0
 */
public class LambdaTestMain {


    @Test
    public void test1() {
        //采用lambda表达式启用一个线程
        new Thread(() -> {
            System.out.println("启动了一个新线程：" + Thread.currentThread().getName());
        }).start();

    }


    @Test
    public void forEach() {
        //假设有一个字符串列表，需要打印出其中所有长度大于3的字符串.
        // 使用forEach()结合匿名内部类迭代
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String str) {
                if (str.length() > 3)
                    System.out.println(str);
            }
        });

        System.out.println("----------------------------------------");

        list.forEach(s -> {
            if (s.length() > 3)
                System.out.println(s);
        });


    }

    @Test
    public void removeIf(){
        //假设有一个字符串列表，需要删除其中所有长度大于3的字符串。
        // 使用removeIf()结合匿名名内部类实现
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        list.removeIf(new Predicate<String>(){ // 删除长度大于3的元素
            @Override
            public boolean test(String str){
                return str.length()>3;
            }
        });

        for (String s : list) {
            System.out.println(s);
        }

        ArrayList<String> list1 = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));

        System.out.println("-----------------------------------------");
        list1.removeIf(str -> str.length()>3); // 删除长度大于3的元素
        for (String s : list1) {
            System.out.println(s);
        }

    }

    @Test
    public void replaceAll(){
        //假设有一个字符串列表，将其中所有长度大于3的元素转换成大写，其余元素不变。
        // 使用匿名内部类实现
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        list.replaceAll(new UnaryOperator<String>(){
            @Override
            public String apply(String str){
                if(str.length()>3)
                    return str.toUpperCase();
                return str;
            }
        });


        // 使用Lambda表达式实现
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        list1.replaceAll(str -> {
            if(str.length()>3)
                return str.toUpperCase();
            return str;
        });


    }

    @Test
    public void sort(){

        // List.sort()方法结合Lambda表达式
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        list.sort((str1, str2) -> str1.length()-str2.length());
        for (String s : list) {
            System.out.println(s);
        }

    }



    @Test
    public void forEachTest(){
        IntStream.range(1, 10)
                .peek(x -> System.out.print("\nA" + x))
                .limit(3)
                .peek(x -> System.out.print("B" + x))
                .forEach(x -> System.out.print("C" + x));


        IntStream.range(1, 10)
                .peek(x -> System.out.print("\nA" + x))
                .skip(6)
                .peek(x -> System.out.print("B" + x))
                .forEach(x -> System.out.print("C" + x));


    }

}
