package com.rookie.bigdata.fastjson;

import com.alibaba.fastjson.JSON;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/4/21 22:42
 */
public class FastJsonMain {

    public static void main(String[] args) {

        String str="{\"name\":\"zhangsan\",\"t_address\":\"北京\"，\"age\":\"20\"}";

       // User user= JSON.parse(str,User.class);
        User user = JSON.parseObject(str, User.class);

        System.out.println(user);

    }
}
