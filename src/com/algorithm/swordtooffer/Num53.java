package com.algorithm.swordtooffer;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/6/7 17:26
 */
public class Num53 {

//    public int search(int[] nums, int target) {
//        if(nums==null || nums.length==0){
//            return 0;
//        }
//
//        int left=0;
//        int right=nums.length-1;
//
//        while(left<=right){
//            int mid=(left+right)>>>1;
//            if(nums[mid]==target){
//                int lIndex=mid,rIndex=mid;
//                while(lIndex-1>=0 && nums[lIndex-1]==nums[mid]){
//                    lIndex--;
//                }
//                while(rIndex+1<nums.length && nums[rIndex+1]==nums[mid]){
//                    rIndex++;
//                }
//
//                return rIndex-lIndex+1;
//            }else if(nums[mid]>target){
//                right=mid-1;
//            }else{
//                left=mid+1;
//            }
//        }
//        return 0;
//    }

    public int search(int[] nums, int target) {


        if(nums==null || nums.length==0){
            return 0;
        }

        int left=0;
        int right=nums.length-1;
        int count=0;

        while(left<right){
            int mid=(left+right)>>>1;
            if(nums[mid]==target){
                count++;
                int i=mid;
                int j=mid;
                while(i>=left && nums[i]==nums[i-1]){
                    count++;
                    i--;
                }

                while(j<=right && nums[j]==nums[j+1] ){
                    count++;
                    j++;
                }

                return count;
            }else if(nums[mid]>target){
                right--;
            }else{
                left++;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums={1};
        new Num53().search(nums, 1);
    }
}
