package com.algorithm.swordtooffer;

import java.util.Stack;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/6/2 12:32
 */
public class Num9 {

}

class CQueue{
    private Stack<Integer> head;

    private Stack<Integer> tail;

    private int size;

    public CQueue() {
        this.head=new Stack<>();
        this.tail=new Stack<>();
        this.size=0;
    }

    public void appendTail(int value) {
        this.head.push(value);
        size++;
    }

    public int deleteHead() {
        while(head.size()-1>=0){
            tail.push(head.pop());
        }
        int val=head.pop();

        while(!tail.isEmpty()){
            head.push(tail.pop());
        }
        size--;
        return val;
    }
}
