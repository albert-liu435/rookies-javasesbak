package com.java.lang.cloneable;

import java.util.Date;

/**
 * @Classname Employee
 * @Description TODO
 * @Author rookie
 * @Date 2022/1/6 11:57
 * @Version 1.0
 */
public class Employee implements Cloneable {


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
    protected Object clone() throws CloneNotSupportedException {
        Employee cloned = (Employee) super.clone();

        cloned.hireDay = (Date) hireDay.clone();

        return cloned;
    }
}
