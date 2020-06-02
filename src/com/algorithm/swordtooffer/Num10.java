package com.algorithm.swordtooffer;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/6/2 14:06
 */
public class Num10 {


    public int numWays(int n) {
        int[] dp=new int[n+2];
        dp[1]=1;
        dp[2]=2;

        for(int i=3;i<=n;i++){
            dp[i]=(dp[i-1]+dp[i-2])%1000000007;
        }

        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(new Num10().numWays(2));
    }
}
