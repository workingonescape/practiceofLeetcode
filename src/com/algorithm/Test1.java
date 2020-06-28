package com.algorithm;

import java.util.stream.Stream;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/6/23 0:08
 */
public class Test1 {


    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};

        for(int i=0;i<nums.length;i++){
            while(nums[i]!=i){
                if (nums[i] == nums[nums[i]]) {
                    break;
                }
                int temp=nums[i];
                nums[i]=nums[temp];
                nums[temp]=temp;
            }
        }

        for (int i = 0; i <nums.length ; i++) {
            System.out.print(i+" ");
        }
    }
}
