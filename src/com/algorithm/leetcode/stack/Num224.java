package com.algorithm.leetcode.stack;

import java.util.Stack;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/5/26 23:59
 */
public class Num224 {

    public int calculate(String s) {

        Stack<Boolean> stack = new Stack<>();

        int res = 0;
        int opr = 0;

        Character op = null;

        for (char c : s.toCharArray()) {
            if (c == '+' || c == '-') {
                //遇到第一个运算符时，将result置为opr（即第一个运算符左边的数字）
                if (op == null) {
                    res = opr;
                } else {
                    res = cal(op, res, opr);
                }
                op = swap(stack.peek() == null ? false : stack.peek(), c);
                opr = 0;
            }else if (c=='('){
                stack.push(op != null && op == '-');
            }else if (c==')'){
                stack.pop();
            } else if (c != ' ') {
                opr = opr * 10 + c - '0';
            }
        }

        if (op == null) {
            //算式中没有运算符时，opr就是最后的结果
            return opr;
        }else {
            return cal(op, res, opr);
        }

    }

    private Character swap(boolean swap, char c) {
        if (swap) {
            return c == '+' ? '-' : '+';
        } else {
            return c;
        }
    }

    private int cal(Character op, int opr1, int opr2) {
        switch (op) {
            case '+':
                return opr1 + opr2;
            case '-':
                return opr1 - opr2;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        new Num224().calculate(s);
    }
}
