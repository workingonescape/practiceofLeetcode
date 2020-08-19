package com.algorithm.sort;

import com.algorithm.swordtooffer.Num51;

import java.util.Random;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/8/12 1:29
 */
public class MergeSort {


    public static void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }


        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] oldArray, int left, int right) {

        //只有一个元素
        if (left < right) {
            int mid = (left + right) >>> 1;
            sort(oldArray, left, mid);
            sort(oldArray, mid + 1, right);

            // 如果整个数组已经有序，则无需合并，注意这里使用小于等于
            if (oldArray[mid] <= oldArray[mid + 1]) {
                return;
            }

            merge(oldArray, left, mid, right);
        }
    }

    private static void merge(int[] oldArray, int left, int mid, int right) {


        int p1 = left;//左边数组的指针

        int p2 = mid + 1;//右边数组的指针 注意是 mid+1

        int[] temp = new int[right - left + 1];

        int index = 0;

        // 比较左右两部分的元素，哪个小，把那个元素填入temp中
        while (p1 <= mid && p2 <= right) {
            temp[index++] = oldArray[p1] < oldArray[p2] ? oldArray[p1++] : oldArray[p2++];
        }


        // 上面的循环退出后，把剩余的元素依次填入到temp中
        // 以下两个while只有一个会执行
        while (p1 <= mid) {
            temp[index++] = oldArray[p1++];
        }

        while (p2 <= right) {
            temp[index++] = oldArray[p2++];
        }

        //将排序过后的数组拷贝回原数组
        for (int i = 0; i < temp.length; i++) {
            oldArray[left + i] = temp[i];
        }

        //显示置为null help gc
        temp = null;
    }


    public static void main(String[] args) throws Exception {
        int num = 100000;

//        int[] nums = new int[num];
//
//        int bound = 100_000;
//
//        int times = 20;
//
//
//        while (times > 0) {
//            for (int j = 0; j < nums.length; j++) {
//                nums[j] = (bound & 15) + new Random().nextInt(bound);
//
//            }
//            System.out.println("sort start");
//            long start = System.currentTimeMillis();
//            sort(nums);
//
//            long end = System.currentTimeMillis();
//            System.out.println("cost " + (end - start) + " ms");
//
//

//            System.out.println("=======================");
//            times--;
//        }

        int[] nums = {1, 3, 2, 3, 1};

        sort(nums);

        verify(nums);

    }


    private static void verify(int[] nums) throws Exception {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                throw new Exception("sort is wrong");
            }
        }

        System.out.println("sort is ok");
    }
}
