package com.rookie.bigdata.listener;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @ClassName DemoSource
 * @Description 通过DemeSource..ava文件创造一个事件源类，它用一个java.utile.Vector对象来存储所有的事件监听器对象，
 * 存储方式是通过addListener(..)这样的方法。notifyDemeEvent(..)是触发事件的方法，用来通知系统：事件发生了，你调用相应的处理函数（回调函数）吧。
 * @Author
 * @Date 2020/5/11 18:16
 * @Version 1.0
 */
public class DemoSource {

    private Vector repository = new Vector();

    DemoListener dl;

    public DemoSource() {


    }

    public void addDemoListener(DemoListener dl) {

        repository.addElement(dl);

    }

    public void notifyDemoEvent() {

        Enumeration enums = repository.elements();

        while (enums.hasMoreElements()) {

            dl = (DemoListener) enums.nextElement();

            dl.demoEvent(new DemoEvent(this));

        }

    }

}