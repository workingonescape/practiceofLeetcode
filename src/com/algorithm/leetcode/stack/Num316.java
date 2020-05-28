package com.algorithm.leetcode.stack;

import java.util.Stack;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/5/27 0:29
 */
public class Num316 {

    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        if (s.length() < 2) {
            return s;
        }

        boolean[] in = new boolean[26];

        int[] lastIndex = new int[26];

        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            if (in[cur - 'a']) {
                continue;
            }

            // 栈顶元素在后面是否还会遇到
            while (!stack.isEmpty() && stack.peek() > cur && lastIndex[stack.peek() - 'a'] >= i) {
                char peek = stack.pop();
                in[peek - 'a'] = false;
            }

            stack.push(cur);
            in[cur - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "cbacdcbc";
        System.out.println(new Num316().removeDuplicateLetters(s));;
    }
}
