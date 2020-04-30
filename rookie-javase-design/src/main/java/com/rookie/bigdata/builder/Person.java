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

    public Person() {

    }

    public Person(String name, int age, String address, String idCard) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.idCard = idCard;
    }


    public static Person.SelfBuilder self() {
        return new Person.SelfBuilder();
    }

    public static class SelfBuilder {
        private String name;
        private int age;
        private String address;
        private String idCard;

        public Person.SelfBuilder buildName(String name) {
            this.name = name;

            return this;
        }

        public Person.SelfBuilder buildAge(int age) {
            this.age = age;
            return this;
        }

        public Person.SelfBuilder buildAddress(String address) {
            this.address = address;
            return this;
        }

        public Person.SelfBuilder buildIDCard(String idCard) {
            this.idCard = idCard;
            return this;

        }

        public Person build() {
            Person person = new Person();
            person.address = address;
            person.name = name;
            person.idCard = idCard;
            person.age = age;
            return person;
        }


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
