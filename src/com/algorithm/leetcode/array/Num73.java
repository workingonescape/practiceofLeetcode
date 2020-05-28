package com.algorithm.leetcode.array;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/5/28 0:28
 */
public class Num73 {

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        boolean flag = false;

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flag = true;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (flag) {
                matrix[i][0] = 0;
            }
        }

    }


    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        new Num73().setZeroes(matrix);

    }
}
