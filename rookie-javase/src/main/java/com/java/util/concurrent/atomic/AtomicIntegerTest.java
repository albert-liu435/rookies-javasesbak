package com.java.util.concurrent.atomic;

import org.junit.Test;
import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntUnaryOperator;

/**
 * @Classname AtomicIntegerTest
 * @Description TODO
 * @Author rookie
 * @Date 2022/3/16 16:59
 * @Version 1.0
 */
public class AtomicIntegerTest {
    //public static AtomicInteger count = new AtomicInteger(0);

//    public static void main(String[] args)  throws Exception{
//
//        int andIncrement = count.getAndIncrement();
//        System.out.println(andIncrement);
//        System.out.println(count.get());
//
//        boolean b = count.compareAndSet(1, 10);
//        System.out.println(b);
//        System.out.println(count.get());
//
//
//        for (int i = 0; i < 1000; i++) {
//            count.incrementAndGet();
//        }
//    }


    @Test
    public void testGetAndAdd()throws Exception{
        AtomicInteger count = new AtomicInteger(0);

        int andAdd = count.getAndAdd(10);
        //返回之前的值10
        System.out.println(andAdd);
        int i = count.addAndGet(10);
        //返回新值20，因为前面加了两次10
        System.out.println(i);

        int getAndUpdate=count.getAndUpdate(new IntUnaryOperator() {
            @Override
            public int applyAsInt(int operand) {
                return operand+10;
            }
        });
        System.out.println(getAndUpdate);
        //返回30,因为已经加了三次10
        System.out.println(count.get());

        int i1 = count.incrementAndGet();
        //输出31
        System.out.println(i1);


    }

}
