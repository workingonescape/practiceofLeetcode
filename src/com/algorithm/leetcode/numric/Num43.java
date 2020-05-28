package com.algorithm.leetcode.numric;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/5/23 0:41
 */
public class Num43 {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n1 = num1.charAt(i) - '0';
                int n2 = num2.charAt(j) - '0';
                int p1=i+j;
                int p2=i+j+1;
                int sum = (res[p2] + n1 * n2);
                res[p2] = sum % 10;
                res[p1] += sum / 10;
            }
        }

        int index=0;
        while (index < res.length && res[index] == 0) {
            index++;
        }

        StringBuilder result = new StringBuilder();
        for (; index < res.length; index++) {
            result.append(res[index]);
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        new Num43().multiply(num1, num2);
    }
}
