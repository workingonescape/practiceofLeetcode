package com.algorithm.leetcode.greedy;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/8/5 20:19
 */
public class Num122 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int maxP=0;

        for (int i = 1; i <prices.length ; i++) {
            if (prices[i] > prices[i - 1]) {
                maxP += prices[i] - prices[i - 1];
            }
        }

        return maxP;
    }
}
