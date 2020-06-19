package com.algorithm.swordtooffer;

import java.util.LinkedList;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/6/11 0:49
 */
public class Num59 {


    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) {
            return new int[0];
        }

        //共会形成 num.length-k+1个窗口
        int[] res = new int[nums.length - k + 1];
        int index=0;

        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            //队列先进先出
            // 在队列不为空的情况下，如果队列尾部的元素小于或等于当前的元素
            // 那么为了维持从大到小的原则，我必须让尾部元素弹出
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }

            // 不走 while 的话，说明我们正常在队列尾部添加元素
            queue.addLast(i);

            // 如果滑动窗口已经略过了队列中头部的元素，则将头部元素弹出
            if (queue.peekFirst() == (i - k)) {
                queue.pollFirst();
            }

            // 看看窗口有没有形成，只有形成了大小为 k 的窗口，我才能收集窗口内的最大值
            if (i >= (k - 1)) {
                res[index++] = nums[queue.peekFirst()];
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] num = {1, 3, -1, -3, 5, 3, 6, 7};
        new Num59().maxSlidingWindow(num, 3);
    }
}
