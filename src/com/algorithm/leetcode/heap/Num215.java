package com.algorithm.leetcode.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/5/24 12:14
 */
public class Num215 {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return -1;
        }

        //默认最小堆
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);

        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            if (queue.size() > k) {
                //把最小的弹出去
                queue.poll();
            }
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        int[] nums={3,2,1,5,6,4};
        new Num215().findKthLargest(nums, 2);
    }
}
