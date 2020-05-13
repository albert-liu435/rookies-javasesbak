package com.rookie.bigdata.listener;

import java.util.EventListener;

/**
 * @ClassName DemoListener
 * @Description 定义新的事件监听接口，该接口继承自EventListener；该接口包含对DemeEvent事件的处理程序：
 * @Author
 * @Date 2020/5/11 18:14
 * @Version 1.0
 */
public interface DemoListener extends EventListener {

    public void demoEvent(DemoEvent dm);
}
