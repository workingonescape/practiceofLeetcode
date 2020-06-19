package com.algorithm.leetcode.array;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/6/7 23:39
 */
public class Num240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0){
            return false;
        }

        for(int i=0;i<matrix.length;i++){
            int[] cur=matrix[i];
            if(cur[0]>target || cur[cur.length-1]<target){
                continue;
            }
            int result = search(target, cur);
            if (result != -1) {
                return true;
            }
        }
        return false;
    }


    private int search(int target,int[] nums){
        int left=0;
        int right=nums.length-1;

        while(left<=right){
            int mid=(left+right)>>>1;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] matrix={{1,   4,  7, 11, 15},{2,   5,  8, 12, 19},{3,   6,  9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};

        new Num240().searchMatrix(matrix, 5);
    }
}
