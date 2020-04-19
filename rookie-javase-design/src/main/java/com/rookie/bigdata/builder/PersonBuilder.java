package com.rookie.bigdata.builder;

/**
 * @ClassName PersonBuilder
 * @Description PersonBuilder
 * @Author
 * @Date 2020/4/15 16:30
 * @Version 1.0
 */
public class PersonBuilder {

    private String name;
    private int age;
    private String address;
    private String idCard;

    public PersonBuilder builderName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder builderAge(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder builderAddress(String address) {
        this.address = address;
        return this;
    }

    public PersonBuilder builderIdCard(String idCard) {
        this.idCard = idCard;
        return this;
    }


    public Person builder() {

        return new Person(this.name, this.age, this.address, this.idCard);
    }


}
