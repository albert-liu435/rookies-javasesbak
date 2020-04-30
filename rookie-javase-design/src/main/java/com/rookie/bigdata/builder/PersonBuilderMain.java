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


        Person build = new Person.SelfBuilder()
                .buildName("张三")
                .buildAddress("北京")
                .buildAge(23)
                .buildIDCard("110")
                .build();

        System.out.println(build);


    }

}
