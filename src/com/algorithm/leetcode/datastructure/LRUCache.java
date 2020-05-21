package com.algorithm.leetcode.datastructure;

import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/5/21 23:12
 */
public class LRUCache {


    private DoubleLinkedList cache;

    private Map<Integer,Node> map;

    private int capacity;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.cache = new DoubleLinkedList();
    }


    public void put(int key, int val) {
        Node node = new Node(key, val);
        if (map.containsKey(key)) {
            cache.remove(map.get(key));
        }else {
            if (cache.getSize() == capacity) {
                Node last = cache.removeLast();
                map.remove(last.key);
            }
        }
        cache.addFirst(node);
        map.put(key, node);
    }


    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        int val=node.val;
        put(key, val);
        return val;
    }


    private class DoubleLinkedList{

        private int size;

        private LRUCache.Node head;

        private LRUCache.Node tail;

        public DoubleLinkedList(){
            this.head = new LRUCache.Node(-1, -1);
            this.tail = new LRUCache.Node(-1, -1);
            this.head.next=tail;
            this.tail.front=head;
        }


        public void addFirst(LRUCache.Node node){
            this.head.next.front=node;
            node.next=this.head.next;
            this.head.next=node;
            node.front = this.head;
            size++;
        }


        public void remove(LRUCache.Node node) {
            node.front.next=node.next;
            node.next.front = node.front;
            size--;
        }


        public LRUCache.Node removeLast(){
            if (tail.front == head) {
                return null;
            }
            LRUCache.Node last = tail.front;
            remove(last);
            return last;
        }

        public int getSize(){
            return size;
        }


    }







    private class Node{
        int key;
        int val;
        Node front;
        Node next;

        public Node(int key,int val){
            this.key = key;
            this.val = val;
            this.front = null;
            this.next = null;
        }
    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4
    }
}
