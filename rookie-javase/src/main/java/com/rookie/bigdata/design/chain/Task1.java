package com.rookie.bigdata.design.chain;

/**
 * @Classname Task1
 * @Description TODO
 * @Author rookie
 * @Date 2021/12/7 16:55
 * @Version 1.0
 */
public class Task1 implements Task {

    private Task task;

    public Task1() {

    }

    public Task1(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println("task1 is run");
        if (task != null) {
            task.run();
        }

    }
}
