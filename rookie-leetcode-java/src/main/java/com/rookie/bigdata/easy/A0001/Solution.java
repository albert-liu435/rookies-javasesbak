package com.rookie.bigdata.easy.A0001;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author rookie
 * @version 1.0
 * @date 2020/6/21 18:07
 */
public class Solution {


    public static void main(String[] args) {

        // int[] a = twoSum(new int[]{10, 2, 3, 9, 4, 8}, 13);

        int[] a = twoSumHashMap(new int[]{10, 2, 3, 9, 4, 8}, 13);

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }


    /**
     * 时间复杂度：O(n^2)
     * 对于每个元素，我们试图通过遍历数组的其余部分来寻找它所对应的目标元素，这将耗费 O(n) 的时间。因此时间复杂度为 O(n^2)。
     * <p>
     * 空间复杂度：O(1)。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }

        }

        throw new IllegalArgumentException("No two sum solution");
    }


    /**
     * 时间复杂度：O(n)O(n)，
     * 我们只遍历了包含有 nn 个元素的列表一次。在表中进行的每次查找只花费 O(1)O(1) 的时间。
     * <p>
     * 空间复杂度：O(n)O(n)，
     * 所需的额外空间取决于哈希表中存储的元素数量，该表最多需要存储 nn 个元素。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumHashMap(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            Integer integer = map.get(nums[i]);
            if (integer != null) {

                return new int[]{integer, i};
            }

            map.put(target - nums[i], i);

        }
        throw new IllegalArgumentException("No two sum solution");
    }


}
