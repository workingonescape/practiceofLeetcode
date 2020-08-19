package com.algorithm.swordtooffer;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/6/12 23:59
 */
public class Num47 {
//    public int maxValue(int[][] grid) {
//        if(grid==null || grid.length==0){
//            return 0;
//        }
//
//        int[][] dp=new int[grid.length+1][grid[0].length+1];
//
//        for(int i=1;i<grid.length;i++){
//            grid[i][0]+=grid[i-1][0];
//        }
//
//        for(int j=1;j<grid[0].length;j++){
//            grid[0][j]+=grid[0][j-1];
//        }
//
//        for(int i=1;i<grid.length;i++){
//            for(int j=1;j<grid[0].length;j++){
//                grid[i][j]+=Math.max(dp[i-1][j],dp[i][j-1]);
//
//            }
//        }
//        return grid[grid.length-1][grid[0].length-1];
//    }

    public int maxValue(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        if(m==0) return 0;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        //初始化 dp[0][0]=grid[0][0];
        dp[0][0] = grid[0][0];


        //初始化 dp[i][0]
        for(int i=1;i<m;i++)
            dp[i][0] = dp[i-1][0]+grid[i][0];

        //初始化 dp[0][j]
        for(int j=1;j<n;j++)
            dp[0][j] = dp[0][j-1]+grid[0][j];

        //从1开始进行遍历
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[m-1][n-1];

    }



    public static void main(String[] args) {
        int[][] grid={{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(new Num47().maxValue(grid));;
    }

}
