package com.rookie.bigdata.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/4/8 7:14
 */
public class PersonMain {

    public static void main(String[] args) throws Exception {
        //通过类加载器获取person对象
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class clazz = classLoader.loadClass("com.rookie.bigdata.reflect.Person");

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
