package com.rookie.bigdata.medium.A018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Solution
 * @Description Solution
 * @Author liuxili
 * @Date 2020/10/15 17:07
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {

    }


    /**
     * 数组和双指针
     * <p>
     * 具体实现时，还可以进行一些剪枝操作：
     * <p>
     * 在确定第一个数之后，如果 \textit{nums}[i]+\textit{nums}[i+1]+\textit{nums}[i+2]+\textit{nums}[i+3]>\textit{target}nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target，说明此时剩下的三个数无论取什么值，四数之和一定大于 \textit{target}target，因此退出第一重循环；
     * 在确定第一个数之后，如果 \textit{nums}[i]+\textit{nums}[n-3]+\textit{nums}[n-2]+\textit{nums}[n-1]<\textit{target}nums[i]+nums[n−3]+nums[n−2]+nums[n−1]<target，说明此时剩下的三个数无论取什么值，四数之和一定小于 \textit{target}target，因此第一重循环直接进入下一轮，枚举 \textit{nums}[i+1]nums[i+1]；
     * 在确定前两个数之后，如果 \textit{nums}[i]+\textit{nums}[j]+\textit{nums}[j+1]+\textit{nums}[j+2]>\textit{target}nums[i]+nums[j]+nums[j+1]+nums[j+2]>target，说明此时剩下的两个数无论取什么值，四数之和一定大于 \textit{target}target，因此退出第二重循环；
     * 在确定前两个数之后，如果 \textit{nums}[i]+\textit{nums}[j]+\textit{nums}[n-2]+\textit{nums}[n-1]<\textit{target}nums[i]+nums[j]+nums[n−2]+nums[n−1]<target，说明此时剩下的两个数无论取什么值，四数之和一定小于 \textit{target}target，因此第二重循环直接进入下一轮，枚举 \textit{nums}[j+1]nums[j+1]。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/4sum/solution/si-shu-zhi-he-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * <p>
     * <p>
     * 复杂度分析
     * <p>
     * 时间复杂度：O(n^3)O(n
     * 3
     * )，其中 nn 是数组的长度。排序的时间复杂度是 O(n \log n)O(nlogn)，枚举四元组的时间复杂度是 O(n^3)O(n
     * 3
     * )，因此总时间复杂度为 O(n^3+n\log n)=O(n^3)O(n
     * 3
     * +nlogn)=O(n
     * 3
     * )。
     * <p>
     * 空间复杂度：O(\log n)O(logn)，其中 nn 是数组的长度。空间复杂度主要取决于排序额外使用的空间。此外排序修改了输入数组 \textit{nums}nums，实际情况中不一定允许，因此也可以看成使用了一个额外的数组存储了数组 \textit{nums}nums 的副本并排序，空间复杂度为 O(n)O(n)。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/4sum/solution/si-shu-zhi-he-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return quadruplets;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                int left = j + 1, right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }
}

