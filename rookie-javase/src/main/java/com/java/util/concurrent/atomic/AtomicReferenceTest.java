package com.java.util.concurrent.atomic;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Classname AtomicReferenceTest
 * @Description TODO
 * @Author rookie
 * @Date 2022/3/17 14:30
 * @Version 1.0
 */
public class AtomicReferenceTest {

    @Test
    public void test1()throws Exception{
        AtomicReference<Student>  atomicReference=new AtomicReference<>();

        Student student=new Student();
        student.setAge(23);
        student.setName("张三");

        Student newStudent=new Student();
        newStudent.setName("李四");
        newStudent.setAge(24);

        atomicReference.set(student);
        System.out.println(atomicReference.get());

        atomicReference.compareAndSet(student,newStudent);
        System.out.println(atomicReference.get());




    }

    static class Student{
        private String name;
        private int age;

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
