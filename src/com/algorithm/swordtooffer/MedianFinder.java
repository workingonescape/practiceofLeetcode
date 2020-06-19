package com.algorithm.swordtooffer;

import java.util.PriorityQueue;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/6/8 23:59
 */
public class MedianFinder {

    private int count;

    private PriorityQueue<Integer> maxHeap;

    private PriorityQueue<Integer> minHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        count=0;
        maxHeap=new PriorityQueue<>((o1,o2) -> o2-o1);
        minHeap=new PriorityQueue<>();
    }

    public void addNum(int num) {

        //更新count
        count++;

        //先去大顶堆
        maxHeap.add(num);
        //再去小顶堆
        minHeap.add(maxHeap.poll());

        //若count为奇数，则小顶堆给大顶堆一个元素
        if((count&1)==1){
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        //若count为奇数  则直接返回大顶堆的堆顶
        if((count&1)==1){
            return (double) maxHeap.peek();
        }else{
            return ((double)maxHeap.peek()+(double)minHeap.peek())/2;
        }
    }

    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        finder.findMedian();
        finder.addNum(3);
        finder.findMedian();
    }
}
