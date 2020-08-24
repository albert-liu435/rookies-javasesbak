package com.rookie.bigdata.A001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TwoSum
 * @Description 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素
 * @Author rookie
 * @Date 2020/6/4 18:20
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {

//        int[] array = {1, 4, 6, 9, 8, 2};
//        int target = 8;
//
//        //int[] ints = Solution.twoSum(array, target);
//        int[] ints = Solution.towSumMap(array, target);
//
//        for (int i = 0; i < ints.length; i++) {
//            System.out.println(ints[i]);
//        }
//        System.out.println(ints);



        List<String> list=new ArrayList<>();

        list.add("张三");
        list.add("李四");


        List<List<String>> lists = splitListByLimit(list, 1);
        System.out.println(lists.size());
        System.out.println(list.size());


    }


    /**
     * 采用循环遍历数组，让其中的两个值进行相加，如果等于目标值的话就直接返回下标
     * 最容易的当然是循环两次，复杂度为 O(n^2),该方法在数组中的值存在重复的情况下，会返回首次出现值的下标
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
        return null;
    }


    /**
     * 该方法是利用map集合，遍历数组中的数据，并以目标值减去该下标的值，然后存储在map集合中，等遍历到下一个数据时，从map集合中
     * 获取下标，如果下标不为空，即为索要找的数据。该方法跟上一个方法刚好相反，即在数组中的值存在重复的情况下，会返回最后出现值的下标
     * @param nums
     * @param target
     * @return
     */
    public static int[] towSumMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            final Integer value = map.get(nums[i]);
            if (value != null) {
                return new int[]{value, i};
            }
            map.put(target - nums[i], i);
        }

        return null;

    }



    //拆分大List
    public static <T> List<List<T>> splitListByLimit(List<T> list, int limit) {
        List<List<T>> lists = new ArrayList<>();

        if (list.size() > limit) {  //判断list大于限制
            int length = list.size() / limit; //list的商
            int i = 0;
            for (; i < length; i++) {
                int tmp = i * limit;
                lists.add(list.subList(tmp, tmp + limit));
            }
            if (list.size() % limit != 0) {
                i *= limit;
                lists.add(list.subList(i, list.size()));
            }
        } else {
            lists.add(list);
        }

        return lists;
    }

}
