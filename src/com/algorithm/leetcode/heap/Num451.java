package com.algorithm.leetcode.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/8/4 1:26
 */
public class Num451 {

    public String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();

        for (char ch : chars) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        //以频率构建最大堆
        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
                (o1,o2) -> map.get(o2)-map.get(o1)
        );

        //将map的keySet全部加入到maxHeap中
        maxHeap.addAll(map.keySet());

        StringBuilder sb = new StringBuilder();
        //开始拼接
        while (!maxHeap.isEmpty()) {
            //获取字符
            char key = maxHeap.poll();
            //获取频率
            int freq = map.get(key);

            for (int i = 0; i < freq; i++) {
                sb.append(key);
            }
        }
        return sb.toString();
    }
}
