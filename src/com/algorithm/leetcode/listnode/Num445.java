package com.algorithm.leetcode.listnode;

import com.algorithm.ListNode;

import java.util.Stack;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/8/6 22:11
 */
public class Num445 {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }

        if(l2==null){
            return l1;
        }

        Stack<ListNode> stack1=buildStack(l1);
        Stack<ListNode> stack2=buildStack(l2);



        ListNode dummyHead=new ListNode(-1);
        ListNode cur=dummyHead;

        int bit=0;
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            int v1=stack1.isEmpty()?0:stack1.pop().val;
            int v2=stack2.isEmpty()?0:stack2.pop().val;
            int sum=v1+v2+bit;
            bit = sum / 10;
            cur.next=new ListNode(sum%10);
            cur=cur.next;
        }

        if (bit > 0) {
            cur.next = new ListNode(bit);
        }

        return reverse(dummyHead.next);
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

    private Stack<ListNode> buildStack(ListNode head){
        if(head==null){
            return null;
        }
        Stack<ListNode> stack=new Stack<>();

        while(head!=null){
            stack.push(head);
            head=head.next;
        }

        return stack;
    }



    public static void main(String[] args) {
        ListNode l1 = ListNode.generate(new int[]{7,2,4,3});
        ListNode l2 = ListNode.generate(new int[]{5, 6, 4});

        ListNode merged = new Num445().addTwoNumbers(l1, l2);
    }
}
