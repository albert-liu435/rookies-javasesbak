package com.rookie.bigdata.factorymethod;

/**
 * @ClassName AbstractFactoryTest
 * @Description AbstractFactoryTest
 * @Author rookie
 * @Date 2020/6/19 11:21
 * @Version 1.0
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        try {
            Product a;
            AbstractFactory af;
            af = (AbstractFactory) ReadXML1.getObject();
            a = af.newProduct();
            a.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
