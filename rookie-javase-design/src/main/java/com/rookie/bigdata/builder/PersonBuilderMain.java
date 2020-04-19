package com.rookie.bigdata.builder;

/**
 * @ClassName PersonBuilderMain
 * @Description PersonBuilderMain
 * @Author
 * @Date 2020/4/15 16:35
 * @Version 1.0
 */
public class PersonBuilderMain {

    public static void main(String[] args) {
        Person person=new PersonBuilder().builderName("张三")
                .builderAge(23)
                .builderAddress("北京")
                .builderIdCard("11034")
                .builder();


        System.out.println(person);
    }

}
