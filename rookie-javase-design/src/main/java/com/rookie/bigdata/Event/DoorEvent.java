package com.rookie.bigdata.Event;

import java.util.EventObject;

/**
 * @ClassName DoorEvent
 * @Description DoorEvent 事件对象（event object）
 * @Author liuxili
 * @Date 2020/6/18 17:24
 * @Version 1.0
 */
public class DoorEvent extends EventObject {
    private String doorState = "";    // 表示门的状态，有“开”和“关”两种

    public DoorEvent(Object source) {
        super(source);
    }

    public void setDoorState(String doorState) {
        this.doorState = doorState;
    }

    public String getDoorState() {
        return this.doorState;
    }
}
