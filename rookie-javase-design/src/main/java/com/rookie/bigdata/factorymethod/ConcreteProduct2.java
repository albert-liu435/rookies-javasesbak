package com.rookie.bigdata.factorymethod;

/**
 * @ClassName ConcreteProduct2
 * @Description ConcreteProduct2
 * @Author rookie
 * @Date 2020/6/19 11:23
 * @Version 1.0
 */
//具体产品2：实现抽象产品中的抽象方法
 public class ConcreteProduct2 implements Product {
    public void show() {
        System.out.println("具体产品2显示...");
    }
}
