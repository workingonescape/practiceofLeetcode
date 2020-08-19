package com.algorithm.swordtooffer;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/8/16 15:53
 */
public class Num39 {


    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int temp=nums[0];
        int count=1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == temp) {
                count++;
            } else if (--count == 0) {
                temp=nums[i];
                count = 1;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        new Num39().majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2});

        List<Integer> res = new ArrayList<>(1);

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.size();

    }
}
