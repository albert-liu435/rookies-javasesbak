package com.rookie.bigdata.util.stream;

import org.junit.Test;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Classname StreamTestMain
 * @Description TODO
 * @Author rookie
 * @Date 2021/10/27 10:44
 * @Version 1.0
 */
public class StreamTestMain {


    @Test
    public void filter() {

        List<String> strings = Arrays.asList("a", "ab", "abc", "abcd", "abcde", "abcdef", "abcdefg", "abcdefgh");
        //过滤出字符串长度大于3的字符串
        long count = strings.stream().filter(s -> {
            return s.length() > 3;
        }).count();

        strings.stream().filter(s -> {
            return s.length() > 3;
        }).forEach(
                System.out::println
        );

        System.out.println(count);
        //System.out.println(s1);
    }

    @Test
    public void map() {

        //将字符串添加"h"再过滤出大于3的字符串
        List<String> strings = Arrays.asList("a", "ab", "abc", "abcd", "abcde", "abcdef", "abcdefg", "abcdefgh");
        long count = strings.stream().map(s -> s + "h").filter(s -> s.length() > 3).count();
        System.out.println(count);

        List<String> collect = strings.stream().map(s -> s + "h").filter(s -> s.length() > 3).collect(Collectors.toList());
        for (String s : collect) {
            System.out.println(s);
        }

    }

    @Test
    public void mapToInt() {

        ToIntFunction<String> toIntFunction = new ToIntFunction<String>() {
            @Override
            public int applyAsInt(String value) {
                return new Integer(value);
            }
        };


        //将字符串数字转换为int类型
        //mapToLong mapToDouble功能类似
        List<String> strings = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8");

        int[] ints = strings.stream().mapToInt(s -> new Integer(s)).toArray();
        System.out.println(ints);
        for (int anInt : ints) {
            System.out.println(anInt);
        }


    }

    @Test
    public void flatMap() throws Exception {

        Stream<String> lines = Files.lines(Paths.get("C:\\work\\IDEAWorkSpace\\rookie-project\\rookies-javases\\rookie-javase\\src\\main\\java\\com\\rookie\\bigdata\\util\\stream\\StreamTestMain.java"), StandardCharsets.UTF_8);
        //将数据按照空格进行分割
        Stream<String> words = lines.flatMap(line -> Stream.of(line.split("")));
        words.forEach(
                System.out::println
        );

        //将两个list合并成一个list
        List<Integer> list = (List<Integer>) Stream.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(8, 9, 10, 11, 12))
                .flatMap(list1 -> list1.stream()).collect(Collectors.toList());

        for (int i = 0, length = list.size(); i < length; i++) {
            System.out.println(list.get(i));
        }


        //扁平化流
        //找出数组中唯一的字符
        String[] strArray = {"hello", "world"};

        //具体实现
        List<String> res = Arrays.stream(strArray)
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .distinct() //进行去重操作
                .collect(Collectors.toList());
        System.out.println(res);


        //flatMapToInt,flatMapToLong,flatMapToDouble功能类似

    }

    @Test
    public void distinct() {


        Stream<String> stream = Stream.of("I", "love", "write", "java", "code", "I", "love", "write", "java", "code");
        //进行去重操作,最后只剩下"I", "love", "write", "java", "code"
        stream.distinct()
                .forEach(str -> System.out.println(str));

    }

    @Test
    public void sorted() {

        //进行排序操作
        Stream<String> stream = Stream.of("I", "love", "write", "java", "code", "I", "love", "write", "java", "code");
        //进行去重操作,最后只剩下"I", "love", "write", "java", "code"
        stream.distinct().sorted().forEach(
                System.out::println
        );
        System.out.println("----------------------------");

        //按照数字长度进行倒叙排列
        Stream.of("I", "love", "write", "java", "code", "I", "love", "write", "java", "code").distinct().sorted((s1, s2) -> {
            return s2.length() - s1.length();
        }).forEach(
                System.out::println
        );


    }


    @Test
    public void peek() {
        List<String> collect = Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());

        System.out.println(collect.size());


        Stream<String> stream = Stream.of("hello", "Stream");
        stream.peek(System.out::println).collect(Collectors.toList());
    }

    @Test
    public void limit() {
        //限流操作，比如数据流中有4个 我只要出前2个就可以使用。
        Stream<String> stream = Stream.of("one", "two", "three", "four");
        List<String> collect = stream.limit(2).collect(Collectors.toList());
        System.out.println(collect.get(0));


    }

    @Test
    public void skip() {
        //跳过操作，跳过某些元素
        Stream<String> stream = Stream.of("one", "two", "three", "four");
        List<String> collect = stream.skip(2).collect(Collectors.toList());

        for (String s : collect) {
            System.out.println(s);
        }

    }


    @Test
    public void reduce() {

        //对所有的数据进行求和
        List<Integer> list = Arrays.asList(2, 3, 1, 10, 23, 18);
        // Stream<Integer> integerStream = Stream.of(2, 3, 1, 10, 23, 18);

        Optional<Integer> reduce = list.stream().reduce((a, b) -> a + b);

        Integer integer = reduce.get();
        System.out.println(integer);
        //在10的基础上对所有的数据求和
        Integer reduce1 = list.stream().reduce(10, Integer::sum);
        System.out.println(reduce1);

        Integer reduce2 = list.stream().reduce(10, (a, b) -> a + b);
        System.out.println(reduce2);

        System.out.println("-------------------------------------------------");

    //这里运用的是串行流
        Integer singleStream  = list.stream().reduce(0,
                (a, b) -> {
                    System.out.println("accumulator: a:" + a + "  b:" + b);
                    return a + b;
                },
                (a, b) -> {
                    System.out.println("combiner: a:" + a + "  b:" + b);
                    return a * b;
                });
        System.out.println(singleStream);

        //这里运用的并行流
        Integer parallelStream  = list.parallelStream().reduce(0,
                (a, b) -> {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println("accumulator: a:" + a + "  b:" + b);
                    return a + b;
                },
                (a, b) -> {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println("combiner: a:" + a + "  b:" + b);
                    return a * b;
                });
        System.out.println(parallelStream);


    }

    @Test
    public void reduce2(){

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);


        //这里运用的并行流,最后算出集合中数据的积
        Integer parallelStream  = list.parallelStream().reduce(0,
                (a, b) -> {
                   // System.out.println();
                    System.out.println(Thread.currentThread().getName()+" accumulator: a:" + a + "  b:" + b);
                    return a + b;
                },
                (a, b) -> {
                   // System.out.println(Thread.currentThread().getName());
                    System.out.println(Thread.currentThread().getName()+" combiner: a:" + a + "  b:" + b);
                    return a * b;
                });
        System.out.println(parallelStream);
    }



    @Test
    public void conllect(){


        //将流转换为其他形式,接受一个Collector接口的实现,用于给Stream中的元素做汇总的方法
        Stream<String> stringStream = Stream.of("hello","everyone","I","love","java");
        List<String> asList = stringStream.collect(Collectors.toList());

        for (String s : asList) {
            System.out.println(s);
        }

        Stream<String> stringStream2 = Stream.of("hello","everyone","I","love","java");
        String concat = stringStream2.collect(StringBuilder::new, StringBuilder::append,
                StringBuilder::append).toString();
        System.out.println(concat);

    }


    @Test
    public void min(){
        //取出最小值
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        Optional<Integer> min = list.stream().min(Integer::compareTo);
        System.out.println(min.get());

        Optional<Integer> min1 = list.stream().min((a,b)->{
            return (a <= b) ? -1 : 1;
        });
        System.out.println(min1.get());

    }

    @Test
    public void max(){
        //取出最小值
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        Optional<Integer> min = list.stream().max(Integer::compareTo);
        System.out.println(min.get());

        boolean allMatch = list.stream().allMatch(e -> e > 10);
        boolean noneMatch = list.stream().noneMatch(e -> e > 10);
        boolean anyMatch = list.stream().anyMatch(e -> e > 4);

        Integer findFirst = list.stream().findFirst().get();
        Integer findAny = list.stream().findAny().get();

        long count = list.stream().count();
    }





}
