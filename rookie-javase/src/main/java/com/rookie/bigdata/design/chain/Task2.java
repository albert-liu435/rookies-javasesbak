package com.rookie.bigdata.design.chain;

/**
 * @Classname Task2
 * @Description TODO
 * @Author rookie
 * @Date 2021/12/7 16:57
 * @Version 1.0
 */
public class Task2 implements Task {

    private Task task;

    public Task2() {

    }

    public Task2(Task task) {
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
