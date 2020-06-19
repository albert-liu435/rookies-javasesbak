package com.rookie.bigdata.Event;


import java.util.EventListener;

/**
 * @ClassName IDoorListener
 * @Description IDoorListener 事件监听器
 * @Author liuxili
 * @Date 2020/6/18 17:25
 * @Version 1.0
 */
public interface IDoorListener extends EventListener {
    //EventListener是所有事件侦听器接口必须扩展的标记接口、因为它是无内容的标记接口、
    //所以事件处理方法由我们自己声明如下：
    public void dealDoorEvent(DoorEvent event);
}