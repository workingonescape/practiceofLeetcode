package com.algorithm.swordtooffer;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/6/2 12:32
 */
public class Num9 {

}

class CQueue{


    private LinkedList<Integer> head;

    private LinkedList<Integer> tail;

    public CQueue() {
        this.head = new LinkedList<>();
        this.tail = new LinkedList<>();
    }

    public void appendTail(int value) {
        head.addLast(value);
    }

    public int deleteHead() {
        if (!tail.isEmpty()) {
            return tail.removeLast();
        }
        if (head.isEmpty()) {
            return -1;
        }
        while (!head.isEmpty()) {
            tail.addLast(head.removeLast());
        }
        return tail.removeLast();
    }


    public static void main(String[] args) {
        CQueue queue = new CQueue();
        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);
        queue.appendTail(4);

        queue.deleteHead();
        queue.deleteHead();
        queue.deleteHead();
        queue.deleteHead();

        queue.appendTail(5);

    }

}
