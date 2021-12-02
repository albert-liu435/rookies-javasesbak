package com.rookie.bigdata.dolyw.threadlocal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname TestMain
 * @Description TODO
 * @Author rookie
 * @Date 2021/11/30 10:37
 * @Version 1.0
 */
public class TestMain {

    public static void main(String[] args) {
        //测试引用传递
        Map<String, String> a = new HashMap<>();
        a.put("1", "a");
        List<Map> b = new ArrayList<Map>();
        b.add(a);
//        Map map=b.get(0);
//        map=null;
        a = null;
        Map aa = b.get(0);
        System.out.println(aa.get("1"));
        //结论传递的是引用的副本
        //测试值传递
        int xx = 1;
        add(xx);
        System.out.print(xx);

    }

    public static void add(int temp) {
        temp++;
    }
}
