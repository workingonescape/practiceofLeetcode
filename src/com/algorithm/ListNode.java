package com.algorithm;

import java.util.List;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/6/2 17:04
 */
public class ListNode {

    public int val;
    public ListNode next;
    public  ListNode(int x) { val = x; }



    public static ListNode generate(int[] nums){
        if (nums == null || nums.length == 0) {
            return null;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        for (int i : nums) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }

        return dummyHead.next;
    }
}
