package com.rookie.bigdata.factorymethod;

/**
 * @ClassName ConcreteFactory1
 * @Description ConcreteFactory1
 * @Author rookie
 * @Date 2020/6/19 11:23
 * @Version 1.0
 */
public class ConcreteFactory1 implements AbstractFactory {
    public Product newProduct() {
        System.out.println("具体工厂1生成-->具体产品1...");
        return new ConcreteProduct1();
    }
}