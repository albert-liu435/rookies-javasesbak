package com.rookie.bigdata.easy.A1099;

import java.util.Arrays;

/**
 * 给你一个整数数组 A 和一个整数 K，请在该数组中找出两个元素，使它们的和小于 K 但尽可能地接近 K，返回这两个元素的和。
 * <p>
 * 如不存在这样的两个元素，请返回 -1。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [34,23,1,24,75,33,54,8], K = 60
 * 输出：58
 * 解释：
 * 34 和 24 相加得到 58，58 小于 60，满足题意。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-less-than-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @ClassName Solution
 * @Description Solution
 * @Author liuxili
 * @Date 2020/10/16 10:22
 * @Version 1.0
 */
public class Solution {

    public int twoSumLessThanK(int[] A, int K) {
        if (A == null || A.length == 0) {
            return -1;
        }
        //进行排序
        Arrays.sort(A);
        int result = Integer.MIN_VALUE;
        int left = 0;
        int right = A.length - 1;
        while (left < right) {
            int sum = A[left] + A[right];

            if (sum >= K) {
                right--;

            } else {
                left++;
                //并且对两个数据进行交换
                result = result >= sum ? result : sum;
            }
        }

        return result == Integer.MIN_VALUE ? -1 : result;

    }
}
