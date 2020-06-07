package com.algorithm.swordtooffer;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/6/6 0:38
 */
public class Num66 {

    public int[] constructArr(int[] a) {
        if(a==null || a.length==0){
            return new int[0];
        }

        int len=a.length;

        int[] res=new int[len];

        res[0]=1;

        for(int i=1;i<len;i++){
            res[i]=a[i-1]*res[i-1];
        }

        int k=1;

        for(int i=len-2;i>=0;i--){
            res[i+1]=res[i+1]*k;
            k*=res[i+1];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        new Num66().constructArr(nums);
    }
}
