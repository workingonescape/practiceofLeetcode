package com.algorithm.swordtooffer;

import java.util.Arrays;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/8/11 15:35
 */
public class Num45 {


    public String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        String[] strs = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));

        StringBuilder res = new StringBuilder();

        for (String s : strs) {
            res.append(s);
        }

        return res.toString();
    }


    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};

        new Num45().minNumber(nums);

    }
}
