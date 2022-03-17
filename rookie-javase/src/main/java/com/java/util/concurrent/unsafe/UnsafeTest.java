package com.java.util.concurrent.unsafe;

import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname UnsafeTest
 * @Description TODO
 * @Author rookie
 * @Date 2022/3/16 17:07
 * @Version 1.0
 */
public class UnsafeTest {

    @Test
    public void test1() throws Exception {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe unsafe = (Unsafe) theUnsafe.get(null);
        System.out.println(unsafe);

        long valueOffset = unsafe.objectFieldOffset
                (AtomicInteger.class.getDeclaredField("value"));
        System.out.println(valueOffset);
    }


    @Test
    public void test2() throws Exception {
        String expressNo = "abc*";
        System.out.println(expressNo.contains("*"));
    }
}
