package com.rookie.bigdata.lang.annotation;

import org.junit.Test;

import java.lang.reflect.Method;


/**
 * @Classname PersonTest
 * @Description TODO
 * @Author rookie
 * @Date 2021/10/22 16:52
 * @Version 1.0
 */
public class PersonTest {


    @Test
    public void test1() throws Exception{
        Class<?> personClass = ClassLoader.getSystemClassLoader().loadClass("com.rookie.bigdata.lang.annotation.Person");

        Person personInstance = (Person)personClass.newInstance();
        Method method = personClass.getMethod("boy", new Class[]{String.class});

        method.invoke(personInstance,new Object[]{"张三"});

        //获取注解上面的值
        if(method.isAnnotationPresent(MyAnnotation.class)){
            //获取上面的注解
            MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);

            //获取注解的值
            String[] value = annotation.value();
            for (String s : value) {
                System.out.println(s);
            }
        }
    }


}