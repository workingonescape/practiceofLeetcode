package com.algorithm.swordtooffer;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/8/12 2:47
 */
public class Num51 {



        //归并算法
        public int reversePairs(int[] nums) {
            return reversePairs(nums,0,nums.length-1);
        }

        private int reversePairs(int[] nums,int left,int right){
            if(left>=right){
                return 0;
            }

            int mid=(left+right)>>>1;

            int leftCount=reversePairs(nums,left,mid);
            int rightCount=reversePairs(nums,mid+1,right);

            if(nums[mid]<=nums[mid+1]){
                return leftCount+rightCount;
            }

            int count=merge(nums,left,mid,right);

            return count+leftCount+rightCount;

        }

        private int merge(int[] nums,int left,int mid,int right){

            int p1=left;//左边指针
            int p2=mid+1;//右边指针
            int count=0;

            int[] temp=new int[right-left+1];

            int index=0;

            while(p1<=mid && p2<=right){

                count+=nums[p1]<=nums[p2]?p2-(mid+1):0;
                temp[index++]=nums[p1]<=nums[p2]?nums[p1++]:nums[p2++];
            }

            while(p1<=mid){
                temp[index++]=nums[p1++];
                count += p2 - (mid + 1);
            }

            while(p2<=right){
                temp[index++]=nums[p2++];
            }

            for(int i=0;i<temp.length;i++){
                nums[left+i]=temp[i];
            }

            return count;
        }


    public static void main(String[] args) {
        int[] nums = {7, 5, 6, 4};
        new Num51().reversePairs(nums);
    }
}
