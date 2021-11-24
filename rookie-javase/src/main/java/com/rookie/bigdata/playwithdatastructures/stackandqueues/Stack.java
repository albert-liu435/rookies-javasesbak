package com.rookie.bigdata.playwithdatastructures.stackandqueues;

/**
 * @Classname Stack
 * @Description TODO
 * @Author rookie
 * @Date 2021/11/24 11:05
 * @Version 1.0
 */
public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();


}
