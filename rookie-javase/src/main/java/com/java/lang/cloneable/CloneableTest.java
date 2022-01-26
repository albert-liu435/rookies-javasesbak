package com.java.lang.cloneable;

import com.java.lang.comparable.Employee;
import org.junit.Test;

/**
 * @Classname CloneableTest
 * @Description TODO
 * @Author rookie
 * @Date 2022/1/6 11:52
 * @Version 1.0
 */
public class CloneableTest {
//    public static void main(String[] args) {
//        Employee employee=new Employee("zhangsan",5000);
//        Employee employeeNew=employee;
//        employeeNew.setSalary(400);
//        System.out.println(employee);
//    }

    @Test
    public void test1(){
        Employee employee=new Employee("zhangsan",5000);
        Employee employeeNew=employee;
        employeeNew.setSalary(400);
        System.out.println(employee);
    }


    @Test
    public void test2(){
        Employee employee=new Employee("zhangsan",5000);
        Employee employeeNew=employee;
        employeeNew.setSalary(400);
        System.out.println(employee);
    }


    @Test
    public void test3(){


    }

}
