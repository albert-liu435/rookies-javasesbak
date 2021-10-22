package com.rookie.bigdata.util.function;

/**
 * @ClassName User
 * @Description User
 * @Author
 * @Date 2020/4/27 16:49
 * @Version 1.0
 */
public class User {

    private String name;
    private int age;

    public User() {

    }

    public User(String name) {
        this.name = name;
    }

    public Book supplier() {
        return new Book();
    }

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

//    @Override
//    public String toString() {
//        return "User{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }
}
