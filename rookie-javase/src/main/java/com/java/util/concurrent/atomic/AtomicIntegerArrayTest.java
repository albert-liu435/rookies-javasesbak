package com.java.util.concurrent.atomic;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @Classname AtomicReferenceArrayTest
 * @Description TODO
 * @Author rookie
 * @Date 2022/3/17 14:13
 * @Version 1.0
 */
public class AtomicIntegerArrayTest {


    @Test
    public void test1() {
        int[] array = {0, 1, 2, 3, 4, 5, 6};
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(array);
        //返回索引3对应的值
        int i = atomicIntegerArray.get(3);
        System.out.println(i);

        atomicIntegerArray.set(3, 4);
        int ii = atomicIntegerArray.get(3);
        System.out.println(ii);
        //预期值为4，并设置新值为5，此时再获取数组下标为3的值就为5
        boolean b = atomicIntegerArray.compareAndSet(3, 4, 5);
        System.out.println(b);
        int iii = atomicIntegerArray.get(3);
        System.out.println(iii);
    }

}
