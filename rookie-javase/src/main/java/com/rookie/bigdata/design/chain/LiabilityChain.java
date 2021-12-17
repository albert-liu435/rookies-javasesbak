package com.rookie.bigdata.design.chain;

/**
 * @Classname LiabilityChain
 * @Description TODO
 * @Author rookie
 * @Date 2021/12/7 17:00
 * @Version 1.0
 */
public class LiabilityChain {

    public void runChain(){
        Task task3 = new Task1();
        Task task2 = new Task2(task3);
        Task task1 = new Task3(task2);
        task1.run();
    }


    public static void main(String[] args) {
        LiabilityChain chain = new LiabilityChain();
        chain.runChain();
    }
}
