package com.algorithm.swordtooffer;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/6/2 16:47
 */
public class Num17 {

    public int[] printNumbers(int n) {

        int len=1;

        while (n > 0) {
            len*=10;
            n--;
        }

        int[] res = new int[len-1];

        for(int i=0;i<len-1;i++){
            res[i]=i+1;
        }

        return res;
    }

    public static void main(String[] args) {
        new Num17().printNumbers(1);
    }
}
