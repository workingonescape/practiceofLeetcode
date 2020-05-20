package com.algorithm.leetcode.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/5/20 23:12
 */
public class Num18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }

        //排序
        Arrays.sort(nums);


        List<List<Integer>> res = new ArrayList<>();


        int len = nums.length;

        for (int i = 0; i <len-3 ; i++) {

            //去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }


            int min1 = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (min1 > target) {
                continue;
            }

            int max1 = nums[i] + nums[len - 3] + nums[len - 2] + nums[len - 1];

            if (max1 < target) {
                continue;
            }

            for (int j = i+1; j <len-2 ; j++) {

                //去重
                if (j - i > 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int min2 = nums[i] + nums[j] + nums[j + 1] + nums[j + 2];

                if (min2 > target) {
                    continue;
                }

                int max2 = nums[i] + nums[j] + nums[len - 2] + nums[len - 1];

                if (max2 < target) {
                    continue;
                }

                int left=j+1;
                int right=len-1;

                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right])));

                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }

                        left++;
                        right--;
                    } else if (sum > target) {
                        right--;
                    }else {
                        left++;
                    }
                }
            }
        }
        return res;
    }
}
