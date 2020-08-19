package com.algorithm.swordtooffer;

import com.algorithm.ListNode;

import java.util.List;

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

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = pre.next;


        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            if (cur.val == val) {
                pre.next = next;
            }else{
                pre.next = cur;
            }
            pre=pre.next;
            cur = next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.generate(new int[]{4, 5, 1, 9});
        new Num18().deleteNode(head, 1);
    }


}
