package com.algorithm.leetcode.sum;

import java.util.Arrays;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/5/21 0:00
 */
public class Num16 {

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return Integer.MAX_VALUE;
        }

        //排序
        Arrays.sort(nums);


        int closeNum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i <nums.length ; i++) {

            int left=i+1;
            int right=nums.length-1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (Math.abs(target - sum) < Math.abs(target - closeNum)) {
                    closeNum = sum;
                } else if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                }else {
                    return sum;
                }
            }
        }
        return closeNum;
    }

}
