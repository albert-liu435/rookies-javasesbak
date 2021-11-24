package com.rookie.bigdata.util.list;

import org.junit.Test;

import java.util.List;
import java.util.ListIterator;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Classname VectorTest
 * @Description TODO
 * @Author rookie
 * @Date 2021/11/22 11:34
 * @Version 1.0
 */
public class VectorTest {

    @Test
    public void test() {
        try {
            // 测试迭代器的remove方法修改集合结构会不会触发checkForComodification异常
            ItrRemoveTest();
            System.out.println("----分割线----");
            // 测试集合的remove方法修改集合结构会不会触发checkForComodification异常
            ListRemoveTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 测试迭代器的remove方法修改集合结构会不会触发checkForComodification异常
    private void ItrRemoveTest() {
        Vector list = new Vector<>();
        list.add("1");
        list.add("2");
        list.add("3");
        ListIterator itr = list.listIterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
            //迭代器的remove方法修改集合结构
            itr.remove();
        }
    }

    // 测试集合的remove方法修改集合结构会不会触发checkForComodification异常
    private void ListRemoveTest() {
        Vector list = new Vector<>();
        list.add("1");
        list.add("2");
        list.add("3");
        ListIterator itr = list.listIterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
            //集合的remove方法修改集合结构
            list.remove("3");
        }
    }



    @Test
    public void test3() {
        try {
            List list = new CopyOnWriteArrayList<>();
            list.add("1");
            list.add("2");
            list.add("3");
            ListIterator itr = list.listIterator();
            while (itr.hasNext()) {
                System.out.println(itr.next());
                list.add("5");
                list.remove("2");
            }
            System.out.println(list.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

