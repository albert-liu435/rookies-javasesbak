package com.rookie.bigdata.playwithdatastructures.stackandqueues;

/**
 * @Classname ArrayStackMain
 * @Description TODO
 * @Author rookie
 * @Date 2021/11/24 11:11
 * @Version 1.0
 */
public class ArrayStackMain {

    public static void main(String[] args) {
        ArrayStack<Integer> stack=new ArrayStack<>();

        for(int i=0;i<5;i++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
