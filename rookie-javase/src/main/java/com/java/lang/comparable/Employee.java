package com.java.lang.comparable;

import java.util.Date;

/**
 * @Classname Employee
 * @Description TODO
 * @Author rookie
 * @Date 2022/1/6 11:22
 * @Version 1.0
 */
public class Employee implements Comparable<Employee> {

    private String name;

    private double salary;

    private Date hireDay;



    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    public Date getHireDay() {
        return hireDay;
    }

    public void setHireDay(Date hireDay) {
        this.hireDay = hireDay;
    }

    @Override
    public int compareTo(Employee other) {
        return Double.compare(salary, other.salary);
    }
}
