package com.rookie.bigdata.design.chain;

/**
 * @Classname Task3
 * @Description TODO
 * @Author rookie
 * @Date 2021/12/7 16:58
 * @Version 1.0
 */
public class Task3 implements Task {

    private Task task;

    public Task3() {

    }

    public Task3(Task task) {
        this.task = task;
    }


    @Override
    public void run() {
        System.out.println("Task2 is run");
        if (task != null) {
            task.run();
        }
    }
}
