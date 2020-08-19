package com.algorithm.leetcode.listnode;

import com.algorithm.ListNode;

import java.util.List;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/8/9 0:37
 */
public class Num83 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;

        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.generate(new int[]{1, 1, 2, 2, 3});
        new Num83().deleteDuplicates(head);
    }
}
