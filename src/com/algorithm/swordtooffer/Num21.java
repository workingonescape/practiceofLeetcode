package com.algorithm.swordtooffer;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/6/7 15:51
 */
public class Num21 {

    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

//        //奇数的下标
//        int even=0;
//
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] % 2 == 1) {
//                swap(nums, i, even);
//                even++;
//            }
//        }
//        return nums;
        int left=0;
        int right = nums.length - 1;

        while (left <right) {
            if (left < right && nums[left] % 2 == 1) {
                left++;
            }
            if (left < right && nums[right] % 2 == 0) {
                right--;
            }
            swap(nums, left, right);
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        new Num21().exchange(nums);
    }
}
