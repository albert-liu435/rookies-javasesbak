package com.rookie.bigdata.fastjson;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/4/21 22:42
 */
public class User {

    private String name;
    @JSONField(defaultValue = "t_address")
    private String address;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
