package com.rookie.bigdata.listener;

/**
 * @ClassName Listener3
 * @Description 通过上面的接口我们再定义事件监听类，这些类具体实现了监听功能和事件处理功能。回想一下上文中那四种实现方式，我们这里不正是使用了其中的第三种——外部类写法的方式吗？
 * @Author
 * @Date 2020/5/11 18:16
 * @Version 1.0
 */
public class Listener3 implements DemoListener {

    public void demoEvent(DemoEvent de) {

        System.out.println("Inside listener3...");

    }

}