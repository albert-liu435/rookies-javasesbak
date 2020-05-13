package com.rookie.bigdata.listener;

import java.util.EventObject;

/**
 * @ClassName DemoEvent
 * @Description  通过DemoEvent.java文件创建DemoEvent类，这个类继承EventObject。这个类的构造函数的参数传递了产生这个事件的事件源（比如各种控件），方法getSource用来获得这个事件源的引用
 * @Author
 * @Date 2020/5/11 18:11
 * @Version 1.0
 */
public class DemoEvent extends EventObject {

    Object obj;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public DemoEvent(Object source) {
        super(source);
        this.obj = source;
    }

    public Object getSource() {

        return obj;

    }

    public void say() {

        System.out.println("This is say  method...");

    }
}
