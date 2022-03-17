package com.java.util.concurrent.atomic;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @Classname AtomicIntegerFieldUpdaterTest
 * @Description TODO
 * @Author rookie
 * @Date 2022/3/17 15:13
 * @Version 1.0
 */
public class AtomicIntegerFieldUpdaterTest {

    @Test
    public void test1()throws Exception{
        AtomicIntegerFieldUpdater<Student> atomicIntegerFieldUpdater= AtomicIntegerFieldUpdater.newUpdater(Student.class,"age");
        Student student=new Student();
        student.setAge(23);
        student.setName("张三");
        System.out.println(atomicIntegerFieldUpdater.get(student));
        //直接返老还童
        boolean b = atomicIntegerFieldUpdater.compareAndSet(student, 23, 2);
        System.out.println(b);
        System.out.println(atomicIntegerFieldUpdater.get(student));
    }




    static class Student{
        public String name;
        //必须为public,且用volatile修饰，否则会报错
        public volatile int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
