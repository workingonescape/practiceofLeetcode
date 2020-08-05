package com.algorithm.swordtooffer;

import java.util.Arrays;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/7/1 0:31
 */
public class Num61 {

    public boolean isStraight(int[] nums) {

        if(nums==null || nums.length<5){
            return false;
        }

        int joker=0;

        Arrays.sort(nums);

        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==0){
                joker++;
            }
           else if(nums[i]==nums[i+1]){
                return false;
            }
        }
        return nums[nums.length-1]-nums[joker]<5;
    }

    public static void main(String[] args) {
        int[] nums={0,0,1,2,5};
        new Num61().isStraight(nums);
    }
}
