package com.algorithm.leetcode.listnode;

import com.algorithm.ListNode;

import java.util.HashMap;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/8/7 12:57
 */
public class Num86 {


    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode minList = new ListNode(-1);
        ListNode maxList = new ListNode(-1);
        ListNode curMin = minList;
        ListNode curMax = maxList;

        while (head != null) {
            if (head.val < x) {
                curMin.next=head;
                curMin = curMin.next;
            }else{
                curMax.next=head;
                curMax = curMax.next;
            }
            head = head.next;
        }

//        curMax.next = null;

        curMin.next = maxList.next;

        return minList.next;

        
    }

    public static void main(String[] args) {
        ListNode head = ListNode.generate(new int[]{1, 4, 3, 2, 5, 2});

        new Num86().partition(head, 3);
    }
}
