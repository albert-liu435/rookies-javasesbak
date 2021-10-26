package com.rookie.bigdata.util.function;

import org.junit.Test;

import java.util.function.Predicate;

/**
 * @Classname PredicateTestMain
 * @Description TODO
 * @Author rookie
 * @Date 2021/10/26 9:54
 * @Version 1.0
 */
public class PredicateTestMain {


    @Test
    public void test() {


        //定义实现类的写法
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.equals("a");
            }
        };

//        //lambda表达式写法
//        Predicate<String> predicate=x->{
//            return x.equals("a");
//        };

        //返回true
        boolean a = predicate.test("a");
        System.out.println(a);
        //返回false
        boolean b = predicate.test("b");
        System.out.println(b);

    }


    @Test
    public void and() {


        Predicate<String> predicate1=new Predicate<String>() {
            @Override
            public boolean test(String s) {
                boolean a = s.equals("a");
                //返回true
                System.out.println(a);
                return a;
            }
        };


        Predicate<String> predicate2=new Predicate<String>() {
            @Override
            public boolean test(String s) {
                //返回false
                boolean b = s.equals("b");
                System.out.println(b);
                return b;
            }
        };

        Predicate<String> and = predicate1.and(predicate2);
        //返回false
        boolean all = and.test("a");
        System.out.println(all);


    }

    @Test
    public void or(){

        Predicate<String> predicate1=new Predicate<String>() {
            @Override
            public boolean test(String s) {
                boolean a = s.equals("a");
                //返回true
                System.out.println(a);
                return a;
            }
        };


        Predicate<String> predicate2=new Predicate<String>() {
            @Override
            public boolean test(String s) {
                //返回false
                boolean b = s.equals("b");
                System.out.println(b);
                return b;
            }
        };

        //下面这两种写法最终返回的结果一致，但是执行过程略有差异
       // Predicate<String> and = predicate1.or(predicate2);

        Predicate<String> and = predicate2.or(predicate1);

        //返回true
        boolean all = and.test("a");
        System.out.println(all);




    }


    @Test
    public void isEqual() {

        //返回true
        Predicate<Object> test = Predicate.isEqual("test");
        boolean test1 = test.test("test");
        System.out.println(test1);

        //返回false
        boolean test2 = Predicate.isEqual("hello").test("test");
        System.out.println(test2);


    }

}
