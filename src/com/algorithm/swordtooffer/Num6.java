package com.algorithm.swordtooffer;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/6/2 12:07
 */
public class Num6 {


    public int[] reversePrint(ListNode head) {
        int count=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            count++;
        }

        int[] res=new int[count];

        ListNode pre=null;
        temp=head;

        while(temp!=null){
            temp.next=pre;
            pre=temp;
            temp=temp.next;
        }

        int index=0;

        while(pre!=null){
            res[index]=pre.val;
            pre=pre.next;
            index++;
        }
        return res;
    }

    private class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static void main(String[] args) {

    }
}
