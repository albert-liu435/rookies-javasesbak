package com.rookie.bigdata.lang.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/4/8 7:14
 */
public class PersonMain {

    public static void main(String[] args) throws Exception {

        //反射主要有以下几种方式
        //方式一
        Class aClass=Person.class;

        //方式二
        Class<?> aClass1 = Class.forName("com.rookie.bigdata.lang.reflect.Person");
        //方式三 通过类加载器
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        Class<?> aClass2 = contextClassLoader.loadClass("com.rookie.bigdata.lang.reflect.Person");


        Constructor<?> declaredConstructor = aClass2.getDeclaredConstructor();
        Person car = (Person) declaredConstructor.newInstance();

        Method setBrand = aClass2.getMethod("setName", String.class);
        setBrand.invoke(car,"李四");
        Method setColor = aClass2.getMethod("setAddress", String.class);
        setColor.invoke(car,"北京");
        System.out.println(car);



        //通过类加载器获取person对象
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class clazz = classLoader.loadClass("com.rookie.bigdata.lang.reflect.Person");

        //获取person的默认构造器对象，并实例化
        Constructor constructor = clazz.getDeclaredConstructor((Class<?>[]) null);
        Person person = (Person) constructor.newInstance();
        System.out.println(person);
        //通过反射设置相关的属性
        Method setName = clazz.getMethod("setName", String.class);
        setName.invoke(person,"张三");
        Method setAge = clazz.getMethod("setAge", int.class);
        setAge.invoke(person,23);
        Method method = clazz.getMethod("setAddress", String.class);
        method.invoke(person,"清东陵");
        System.out.println(person);


    }


}
