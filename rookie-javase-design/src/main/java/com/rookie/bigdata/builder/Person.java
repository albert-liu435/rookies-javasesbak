package com.rookie.bigdata.builder;

/**
 * @ClassName Person
 * @Description Person
 * @Author
 * @Date 2020/4/15 16:30
 * @Version 1.0
 */
public class Person {

    private String name;
    private int age;
    private String address;
    private String idCard;

    public Person(String name, int age, String address, String idCard) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.idCard = idCard;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", idCard='" + idCard + '\'' +
                '}';
    }
}
