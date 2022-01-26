package com.java.lang.comparable;

import java.util.Arrays;

/**
 * @Classname EmployeeTest
 * @Description TODO
 * @Author rookie
 * @Date 2022/1/6 11:24
 * @Version 1.0
 */
public class EmployeeTest {

    public static void main(String[] args) {
        Employee[] staff=new Employee[3];

        staff[0]=new Employee("zhangsan",35000);
        staff[1]=new Employee("lisi",37000);

        staff[2]=new Employee("wangwu",39000);


        Arrays.sort(staff);

        for (Employee employee : staff) {
            System.out.println("name= "+ employee.getName()+", salary="+employee.getSalary());
        }

    }
}
