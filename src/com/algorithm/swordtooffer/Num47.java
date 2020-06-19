package com.algorithm.swordtooffer;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/6/12 23:59
 */
public class Num47 {
    public int maxValue(int[][] grid) {
        if(grid==null || grid.length==0){
            return 0;
        }

        int[][] dp=new int[grid.length+1][grid[0].length+1];

        for(int i=1;i<grid.length;i++){
            grid[i][0]+=grid[i-1][0];
        }

        for(int j=1;j<grid[0].length;j++){
            grid[0][j]+=grid[0][j-1];
        }

        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){
                grid[i][j]+=Math.max(dp[i-1][j],dp[i][j-1]);

            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        int[][] grid={{1,3,1},{1,5,1},{4,2,1}};
        new Num47().maxValue(grid);
    }

}
