package com.algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/5/27 22:39
 */
public class Num54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();

        int left=0;
        int right = matrix.length;
        int top=0;
        int bottom = matrix[0].length;

        int size = matrix.length * matrix[0].length;

        while (res.size() < size) {
            //左->右
            for (int i = left; i <= right && res.size() < size; i++) {
                res.add(matrix[top][i]);
            }


            //top已经访问过 所以++
            top++;
            //上->下
            for (int i = top; i <= bottom && res.size() < size; i++) {
                res.add(matrix[i][right]);
            }

            //bottom已经访问过了 所以--
            right--;

            //右->左
            for (int i = right; i >= left && res.size() < size; i--) {
                res.add(matrix[bottom][i]);
            }
            //右边已经访问过了 所以--
            bottom--;

            for (int i = bottom; i >= top && res.size() < size; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }
        return res;
    }

}
