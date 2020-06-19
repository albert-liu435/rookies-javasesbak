package com.rookie.bigdata.Event;

/**
 * @ClassName TestMain
 * @Description TestMain
 * @Author liuxili
 * @Date 2020/6/18 17:28
 * @Version 1.0
 */
public class TestMain {

    public static void main(String[] args) {
        DoorManager doorManager = new DoorManager();
        // 添加监听器
        doorManager.addDoorListener(new FrontDoorListener());
        doorManager.addDoorListener(new IDoorListener() {
            @Override
            public void dealDoorEvent(DoorEvent event) {
                if (event.getDoorState() != null && event.getDoorState().equals("open")) {
                    System.out.println("后门打开，警示灯亮起");
                } else {
                    System.out.println("后门关闭，警示灯熄灭");
                }
            }
        });

        // 模拟事件
        System.out.println("模拟门打开事件");
        doorManager.fireOpend();

        System.out.println("模拟门关闭事件");
        DoorEvent doorEvent = new DoorEvent(doorManager);
        doorEvent.setDoorState("close");
        doorManager.notifyDoors(doorEvent);
    }
}
