package com.rookie.bigdata.supplier;

import com.rookie.bigdata.domain.Book;
import com.rookie.bigdata.domain.FunctionModel;
import com.rookie.bigdata.domain.User;

import java.util.Date;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @ClassName TestSupplier
 * @Description TestSupplier
 * @Author
 * @Date 2020/4/27 16:49
 * @Version 1.0
 */
public class TestSupplier {

    public static void main(String[] args) {

//        //表示返回两个不同的对象
//
//        Supplier<User> supplier = User::new;
//        User user1 = supplier.get();
//        user1.setAge(12);
//        user1.setName("zhangsan");
//        System.out.println(user1);
//        System.out.println(supplier.get());
//        System.out.println(supplier.get());
//
//        // System.out.println();
//
////
////返回两个不同的结果
//        Supplier<User> supplier1 = () -> new User();
//        System.out.println(supplier1.get());
//        System.out.println(supplier1.get());
////
//        //表示用来返回两个Book对象
//        User user = new User();
//        Supplier<Book> supplier2 = user::supplier;
//        System.out.println(supplier2.get().toString());
//        System.out.println(supplier2.get().toString());

//        FunctionModel fm = new FunctionModel();
////        Consumer<String> staticConsumer = FunctionModel::staticConsumer;
////        staticConsumer.accept("I am static consumer");
////
////        Consumer<String> consumer = fm::consumer;
////        consumer.accept("I am consumer");
////
////        Predicate<String> predicate = fm::predicate;
////        predicate.test("function test!");
//
//        Supplier<Date> supplier = fm::supplier;
//        System.out.println(supplier.get());
//
//        BiConsumer<String,String> biConsumer = fm::biConsumer;
//        biConsumer.accept("function","model");

        User user2=userFactory(User::new);
        System.out.println(user2.toString());

        User user3 = userFactory(() -> new User("lisi"));
        System.out.println(user3.toString());

    }



    public static User userFactory(Supplier<? extends User> supplier){
        User user = supplier.get();
        if(user.getName()==null){
            user.setName("zhangsan");
        }
        user.setAge(23);
        return user;

    }

}
