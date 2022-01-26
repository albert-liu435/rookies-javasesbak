package com.java.util.comparator;

import java.util.Comparator;

/**
 * @Classname LengthComparator
 * @Description TODO
 * @Author rookie
 * @Date 2022/1/6 11:48
 * @Version 1.0
 */
public class LengthComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {


        return o1.length() - o2.length();
    }
}
