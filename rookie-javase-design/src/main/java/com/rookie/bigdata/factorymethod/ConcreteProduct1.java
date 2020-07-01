package com.rookie.bigdata.factorymethod;

/**
 * @ClassName ConcreteProduct1
 * @Description ConcreteProduct1
 * @Author liuxili
 * @Date 2020/6/19 11:22
 * @Version 1.0
 */
//具体产品1：实现抽象产品中的抽象方法
 public class ConcreteProduct1 implements Product {
    public void show() {
        System.out.println("具体产品1显示...");
    }
}
