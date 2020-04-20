package com.rookie.bigdata;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/4/20 7:46
 */
public class LongMain {

    public static void main(String[] args) {

        long startTime=System.currentTimeMillis();
        System.out.println("累加值为："+sum());
        System.out.println("共耗时："+(System.currentTimeMillis()-startTime)+"毫秒");
    }

    private static long sum() {
        //这个比较性能较差
        Long sum = 0L;
        //这个性能较好
        //long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        return sum;
    }
}
