package com.algorithm.swordtooffer;

import com.algorithm.ListNode;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/8/9 1:26
 */
public class Num25 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode dummyHead = new ListNode(-1);

        ListNode cur = dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next=l1;
                l1=l1.next;
            }else {
                cur.next=l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if (l1 == null) {
            cur.next=l2;
        }

        if (l2 == null) {
            cur.next =l1;
        }

        return dummyHead.next;
    }


    public static void main(String[] args) {
//        ListNode l1 = ListNode.generate(new int[]{1, 2, 4});
//        ListNode l2 = ListNode.generate(new int[]{1, 3, 4});
//
//        new Num25().mergeTwoLists(l1, l2);

//
//        for (int i : list) {
//            if (i == 4) {
//                list.set(1, 7);
//            }
//
//            if (i == 3) {
//                list.remove(2);
//
//            }
//
//            System.out.println(i);
//
//        }

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        ListIterator<Integer> iterator = list.listIterator();

//        while (iterator.hasNext()) {
//            int i = iterator.next();
//            System.out.println(i);
//            if (i== 4) {
//                iterator.add(4);
//            }
//        }
//        System.out.println();
        LinkedBlockingQueue<Integer> linkedList = new LinkedBlockingQueue<>();
//        linkedList.add()


    }
}
