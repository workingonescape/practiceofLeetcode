package com.algorithm.leetcode.datastructure;

import java.util.Stack;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/5/21 1:35
 */
public class MinStack {

    private int min;

    private Stack<Integer> stack;

    public MinStack(){
        this.min = Integer.MAX_VALUE;
        this.stack = new Stack<>();
    }

    public void push(int x) {
        if (x <= min) {
            //将前一个最小值推入栈中
            stack.push(min);
            //更新最小值
            min=x;
        }
        stack.push(x);
    }

    public void pop(){
        //如果pop出来的值等于最小值，那么还要继续pop一次，将最小值更新为前一个最小值
        if (min == stack.pop()) {
            min = stack.pop();
        }
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return min;
    }

}
