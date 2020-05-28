package com.algorithm.leetcode.stack;

import java.util.Stack;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/5/24 23:32
 */
public class Num20 {

    public boolean isValid(String s) {
        if(s==null || s.length()==0){
            return true;
        }

        char[] chars=s.toCharArray();

        Stack<Character> stack=new Stack();

        for(int i=0;i<s.length();i++){
            if(chars[i]=='(' || chars[i]=='[' || chars[i]=='{'){
                stack.push(chars[i]);
            }else{
                if(stack.isEmpty()){
                    return false;
                }

                char pop=stack.pop();
                char cur=' ';
                if(chars[i]==')'){
                    cur='(';
                }else if(chars[i]==']'){
                    cur='[';
                }else if(chars[i]=='}'){
                    cur='{';
                }
                if(cur!=pop){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s="()[]{}";
        System.out.println(new Num20().isValid(s));;
    }
}
