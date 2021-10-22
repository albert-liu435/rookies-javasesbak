package com.rookie.bigdata.util.function;

import org.junit.Test;

import java.util.Random;
import java.util.function.*;

/**
 * @Classname SupplierTestMain
 * @Description TODO
 * @Author rookie
 * @Date 2021/10/22 17:29
 * @Version 1.0
 */
public class SupplierTestMain {


    @Test
    public void test1() {

        //用来获取两个User对象,每次调用get方法相当于获取不同的方法
        Supplier<User> supplier = User::new;
        User user1 = supplier.get();
        user1.setAge(12);
        user1.setName("zhangsan");
        System.out.println(user1);
        System.out.println(supplier.get());
        System.out.println(supplier.get());


        //用来返回两个不同的User对象,这个使用的是lambda表达式
        Supplier<User> supplier1 = () -> new User();
        System.out.println(supplier1.get());
        System.out.println(supplier1.get());

        //使用方法引用
        Supplier<User> supplier3 = User::new;
        System.out.println(supplier3.get());
        System.out.println(supplier3.get());

        //上面的实例归根到底就是类似下面这种

        Supplier<User> supplier2 = new SupplierImpl();
        System.out.println(supplier2.get());
        System.out.println(supplier2.get());


    }


    @Test
    public void test2() {

        BooleanSupplier booleanSupplier = () -> {
            return "a".equals("a");
        };
        System.out.println(booleanSupplier.getAsBoolean());


        Random random = new Random();

        // DoubleSupplier doubleSupplier= random::nextDouble;
        DoubleSupplier doubleSupplier = () -> Math.random();
        System.out.println(doubleSupplier.getAsDouble());
        System.out.println(doubleSupplier.getAsDouble());

        IntSupplier intSupplier = random::nextInt;
        System.out.println(intSupplier.getAsInt());
        System.out.println(intSupplier.getAsInt());

        LongSupplier longSupplier = random::nextLong;

        System.out.println(longSupplier.getAsLong());
        System.out.println(longSupplier.getAsLong());






    }


}
