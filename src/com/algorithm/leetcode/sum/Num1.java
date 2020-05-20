package com.algorithm.leetcode.sum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/5/21 0:35
 */
public class Num1 {


    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
}
