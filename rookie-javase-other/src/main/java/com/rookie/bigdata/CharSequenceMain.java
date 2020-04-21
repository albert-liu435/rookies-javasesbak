package com.rookie.bigdata;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/4/21 7:52
 */
public class CharSequenceMain {

    public static void main(String[] args) {
        CharSequence sequence="hello world";
        CharSequence sequence1 = sequence.subSequence(1, 8);
        System.out.println(sequence1);
    }
}
