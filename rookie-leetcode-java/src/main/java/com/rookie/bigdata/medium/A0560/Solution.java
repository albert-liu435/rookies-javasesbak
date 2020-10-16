package com.rookie.bigdata.medium.A0560;

/**
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * <p>
 * 示例 1 :
 * <p>
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 * <p>
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @ClassName Solution
 * @Description Solution
 * @Author liuxili
 * @Date 2020/10/16 9:55
 * @Version 1.0
 */
public class Solution {


    /**
     * 时间复杂度：O(n^2)O(n
     * 2
     * )，其中 nn 为数组的长度。枚举子数组开头和结尾需要 O(n^2)O(n
     * 2
     * ) 的时间，其中求和需要 O(1)O(1) 的时间复杂度，因此总时间复杂度为 O(n^2)O(n
     * 2
     * )。
     * <p>
     * 空间复杂度：O(1)O(1)。只需要常数空间存放若干变量。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/he-wei-kde-zi-shu-zu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
       // Math.max()
        int count = 0;
        for (int start = 0; start < nums.length; ++start) {
            int sum = 0;
            for (int end = start; end >= 0; --end) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }


}
