package com.algorithm.leetcode.greedy;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/6/4 23:23
 */
public class Num121 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        //最大利润
        int max = 0;

        //股票最低价
        int lowest = Integer.MAX_VALUE;

        int len = prices.length;

        for (int i = 0; i <len; i++) {
            if (prices[i] < lowest) {
                lowest = prices[i];
            }
            max = Math.max(max, prices[i] - lowest);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        new Num121().maxProfit(nums);
    }
}
