package com.algorithm.leetcode.heap;

import java.util.*;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/5/24 12:30
 */
public class Num347 {

    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return nums;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            }else {
                map.put(nums[i], 1);
            }
        }

        //最小堆
        Queue<Integer> queue = new PriorityQueue<>(
                //借助于最小堆来比较每个数出现的次数
                (o1, o2) -> map.get(o1) - map.get(o2)
        );

        for (Integer key : map.keySet()) {
            queue.offer(key);
            if (queue.size() > k && map.get(key) > map.get(queue.peek())) {
                queue.poll();
            }
        }
        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }

        int[] res = new int[list.size()];

        for (int i = 0; i <res.length ; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        new Num347().topKFrequent(nums, 2);
    }

}
