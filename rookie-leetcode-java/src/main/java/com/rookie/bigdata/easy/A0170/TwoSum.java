package com.rookie.bigdata.easy.A0170;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 设计并实现一个 TwoSum 的类，使该类需要支持 add 和 find 的操作。
 * <p>
 * add 操作 -  对内部数据结构增加一个数。
 * find 操作 - 寻找内部数据结构中是否存在一对整数，使得两数之和与给定的数相等。
 * <p>
 * 示例 1:
 * <p>
 * add(1); add(3); add(5);
 * find(4) -> true
 * find(7) -> false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-iii-data-structure-design
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @ClassName TwoSum
 * @Description TwoSum
 * @Author liuxili
 * @Date 2020/10/16 9:13
 * @Version 1.0
 */
public class TwoSum {


    private List<Integer> nums;
    private boolean isSorted;

    /**
     * Initialize your data structure here.
     */
    public TwoSum() {
        nums = new ArrayList<>();
    }

    /**
     * Add the number to an internal data structure..
     */
    public void add(int number) {
        nums.add(number);
        isSorted = false;

    }

    /**
     * Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {

        if (!this.isSorted) {
            Collections.sort(nums);
            this.isSorted = true;
        }

        //这里利用双指针查找数据
        int left = 0;
        int right = nums.size() - 1;
        boolean flag = false;

        while (left < right) {

            int tSum = this.nums.get(left) + this.nums.get(right);
            if (tSum > value) {
                --right;
            } else if (tSum < value) {
                ++left;
            } else {
                return true;
            }

        }


        return flag;


    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
