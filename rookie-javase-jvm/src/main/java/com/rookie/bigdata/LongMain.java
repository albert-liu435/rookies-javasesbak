package com.rookie.bigdata;

/**
 * @ClassName LongMain
 * @Description LongMain
 *
 * @Author
 * @Date 2020/4/15 17:39
 * @Version 1.0
 */
public class LongMain {

    public static void main(String[] args) {

        long startTime=System.currentTimeMillis();
        System.out.println(sum());
        System.out.println(System.currentTimeMillis()-startTime);
    }

    private static long sum() {
        //这个比较性能较差
        //Long sum = 0L;
        //这个性能较好
        long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        return sum;
    }
}
