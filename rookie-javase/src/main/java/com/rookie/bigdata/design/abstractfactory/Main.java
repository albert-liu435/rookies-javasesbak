package com.rookie.bigdata.design.abstractfactory;


import com.rookie.bigdata.design.abstractfactory.factory.AbstractFarmFactory;
import com.rookie.bigdata.design.abstractfactory.factory.impl.ChangshaFarmFactoryImpl;
import com.rookie.bigdata.design.abstractfactory.factory.impl.ShenzhenFarmFactoryImpl;

/**
 * 抽象工厂
 *
 * @author wliduo[i@dolyw.com]
 * @date 2020/5/28 11:34
 */
public class Main {

    public static void main(String[] args) {
        // 抽象工厂应用
        AbstractFarmFactory farmFactory = null;
        farmFactory = new ChangshaFarmFactoryImpl();
        farmFactory.getAnimal().show();
        farmFactory.getPlant().show();
        farmFactory = new ShenzhenFarmFactoryImpl();
        farmFactory.getAnimal().show();
        farmFactory.getPlant().show();
    }

}
