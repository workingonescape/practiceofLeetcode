package com.algorithm.leetcode.listnode;

import com.algorithm.ListNode;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/8/6 22:56
 */
public class Num234 {

    public boolean isPalindrome(ListNode head) {

        if(head==null || head.next==null){
            return true;
        }

        ListNode cur = head;
        ListNode slow = cur;
        ListNode fast = cur;

        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode reversedFast=reverse(slow.next);

        slow.next=null;

        while(reversedFast!=null && slow!=null){
            if(reversedFast.val!=slow.val){
                return false;
            }
            reversedFast=reversedFast.next;
            slow=slow.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head){
        if(head==null){
            return null;
        }

        ListNode cur=head;
        ListNode pre=null;

        while(cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }

        return pre;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.generate(new int[]{1,0,0});

        new Num234().isPalindrome(head);
    }
}
