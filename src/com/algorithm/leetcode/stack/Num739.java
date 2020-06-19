package com.algorithm.leetcode.stack;

import java.util.Stack;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/6/11 0:23
 */
public class Num739 {



    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) {
            return new int[0];
        }

        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int preIndex = stack.pop();
                res[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] res = {73, 74, 75, 71, 69, 72, 76, 73};
        new Num739().dailyTemperatures(res);
    }
}
