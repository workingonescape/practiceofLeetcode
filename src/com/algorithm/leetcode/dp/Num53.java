package com.algorithm.leetcode.dp;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/5/31 23:06
 */
public class Num53 {

    public int maxSubArray(int[] nums) {

        //   int maxSum=nums[0];
        //   int nowMax=nums[0];

        //    //从1开始遍历
        //   for(int i=1;i<nums.length;i++){
        //       nowMax=Math.max(nowMax+nums[i],nums[i]);
        //       maxSum=Math.max(nowMax,maxSum);
        //   }

        //   return maxSum;
        //表示以nums[i]结尾的最大子数组和
        int[] dp = new int[nums.length];

        int max = nums[0];
        
        dp[0] = nums[0];
        //状态转移方程 dp[i]=Math.max(dp[i-1],nums[i]+dp[i-1]);
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Num53().maxSubArray(nums));
        ;
    }
}
