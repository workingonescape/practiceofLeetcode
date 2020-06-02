package com.algorithm.swordtooffer;

import com.algorithm.ListNode;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/6/2 17:04
 */
public class Num18 {

    public ListNode deleteNode(ListNode head, int val) {
        if(head==null){
            return null;
        }

        if (head.val == val) {
            return head.next;
        }

        ListNode cur=head;

        while (cur.next.val != val) {
            cur=cur.next;
        }

        cur.next = cur.next.next;

        return head;

    }

    public static void main(String[] args) {
        ListNode root = new ListNode(4);
        root.next = new ListNode(5);

        root.next.next = new ListNode(1);

        root.next.next.next = new ListNode(9);


        new Num18().deleteNode(root, 1);

    }
}
