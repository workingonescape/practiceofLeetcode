package com.algorithm.swordtooffer;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/6/9 0:33
 */
public class Num44 {

    public int findNthDigit(int n) {
        if (n <= 9) {
            return n;
        }
        //位数
        int digit=1;
        //起始数字
        long start=1;
        //数位数量  其中 count=9*start*digit
        long count = 9;

        while (n > count) {
            n -= count;
            digit+=1;
            start*=10;
            count = 9 * digit * start;
        }

        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }


    public static void main(String[] args) {
        new Num44().findNthDigit(1000000000);
    }
}
