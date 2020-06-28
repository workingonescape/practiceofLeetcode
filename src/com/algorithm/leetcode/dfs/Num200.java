package com.algorithm.leetcode.dfs;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/6/24 1:15
 */
public class Num200 {


    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //当矩阵中是陆地的时候开始遍历
                // 遍历几次就有几个岛屿
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        //先判断位置是否越界
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1' ) {
            return;
        }
        //将访问过的节点设置为2 以用来标识访问过
        grid[i][j] = '2';
        //开始四个方向的遍历
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }


}
