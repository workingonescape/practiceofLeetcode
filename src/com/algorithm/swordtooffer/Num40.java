package com.algorithm.swordtooffer;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/6/7 16:24
 */
public class Num40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k < 0) {
            return new int[0];
        }

        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int num : arr) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[] res = new int[queue.size()];

        for (int i = 0; i <res.length ; i++) {
            res[i] = queue.poll();
        }
        return  res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        int k=2;
        new Num40().getLeastNumbers(arr, k);
    }
}
