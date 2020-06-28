package com.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/6/20 14:16
 */
public class Solution {

    /***
     * 四个自然数
     *
     * 去掉其中一个自然数
     *
     * 使用其余三个组成一个最大
     */

    public int findMax(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        int res=0;

        for (int i = 0; i <nums.length ; i++) {
            if (nums[i] != min) {
                res=res*10+nums[i];
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().findMax(new int[]{2, 5, 1, 9}));
    }
}
