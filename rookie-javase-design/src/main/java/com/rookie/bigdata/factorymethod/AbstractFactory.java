package com.rookie.bigdata.factorymethod;

/**
 * @ClassName AbstractFactory
 * @Description AbstractFactory
 * @Author rookie
 * @Date 2020/6/19 11:23
 * @Version 1.0
 */
//抽象工厂：提供了厂品的生成方法
public interface AbstractFactory {
    public Product newProduct();
}
