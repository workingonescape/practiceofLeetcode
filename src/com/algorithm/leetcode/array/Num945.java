package com.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/5/28 1:10
 */
public class Num945 {

    public int minIncrementForUnique(int[] A) {

//        //先排序
//        Arrays.sort(A);
//
//        //结果
//        int res=0;
//
//        for (int i = 1; i <A.length ; i++) {
//            // 当前一个数大于后一个数 时 开始增加
//            if (A[i] <= A[i - 1]) {
//                int temp = A[i];
//                A[i] = A[i - 1] + 1;
//                res+=A[i]-temp;
//            }
//        }
//        return res;

        int[] pos = new int[80000];

        Arrays.fill(pos, -1);

        int res=0;

        for (int a : A) {
            int b = findPos(pos,a);
            res += b - a;
        }
        return res;
    }


    private int findPos(int[] pos,int a){
        int b = pos[a];
        if (b == -1) {
            pos[a]=a;
            return a;
        }
        b = findPos(pos, b + 1);
        pos[a] = b;
        return b;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 2, 1, 7};
        new Num945().minIncrementForUnique(arr);
    }
}
