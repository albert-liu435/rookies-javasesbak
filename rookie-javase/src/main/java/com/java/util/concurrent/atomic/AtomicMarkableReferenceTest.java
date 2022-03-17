package com.java.util.concurrent.atomic;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Classname AtomicMarkableReferenceTest
 * @Description TODO
 * @Author rookie
 * @Date 2022/3/17 14:38
 * @Version 1.0
 */
public class AtomicMarkableReferenceTest {
    @Test
    public void test1() throws Exception {

        Student student = new Student();
        student.setAge(23);
        student.setName("张三");

        Student newStudent = new Student();
        newStudent.setName("李四");
        newStudent.setAge(24);

        AtomicMarkableReference<Student> atomicReference = new AtomicMarkableReference<>(student,false);
        //初始化的值
        System.out.println(atomicReference.isMarked());
        System.out.println(atomicReference.getReference());

        //修改失败
        boolean b = atomicReference.compareAndSet(student, newStudent, true, false);
        System.out.println(atomicReference.isMarked());
        System.out.println(b);
        System.out.println(atomicReference.getReference());


        //修改成功
        boolean b1 = atomicReference.compareAndSet(student, newStudent, false, true);
        System.out.println(atomicReference.isMarked());
        System.out.println(b1);
        System.out.println(atomicReference.getReference());



    }

    static class Student {
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
