package com.algorithm.sort;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/8/3 17:26
 */
public class QuickSort {


    public static void quickSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quickSort(arr, 0, arr.length-1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        int pivot;

        if (low < high) {
            pivot = partition(arr, low, high);
            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        //取每个序列的第一个值作为基准值
        int pivot = arr[low];

        while (low < high) {

            //从序列的右边开始向左遍历 直到找到小于基准值的元素
            while (high > low && arr[high] >= pivot) {
                high--;
            }

            //将元素直接赋予给左边第一个 即pivot的位置
            arr[low] = arr[high];

            //从序列的左边向右查找 直到找到大于基准值的元素
            while (low < high && arr[low] <= pivot) {
                low++;
            }

            //
            arr[high] = arr[low];
        }
        //最后的low是基准值所在的位置
        return low;
    }


}
