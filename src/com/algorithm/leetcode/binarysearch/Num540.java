package com.algorithm.leetcode.binarysearch;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/8/6 16:48
 */
public class Num540 {


    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left=0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) >>> 1;

            if (mid % 2 == 1) {
                mid--;//保证 mid left right 都在偶数位上 使得查找区间大小一直是奇数
            }

            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            }else{
                right = mid;
            }
        }
        return nums[left];
    }


    public static void main(String[] args) {


        int[] nums = {3,3,7,7,10,11,11};

        new Num540().singleNonDuplicate(nums);
    }
}
