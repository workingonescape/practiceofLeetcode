package com.algorithm.swordtooffer;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/6/23 0:22
 */
public class Num4 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int i=0;
        int j=matrix[0].length-1;

        while (i < matrix.length && j >= 0) {
            if (matrix[i][j]<target) {
                i++;
            }
            if(matrix[i][j]>target){
                j--;
            }
            if (matrix[i][j] == target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};


        new Num4().findNumberIn2DArray(matrix, 20);
    }
}
