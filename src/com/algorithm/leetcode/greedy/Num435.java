package com.algorithm.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/8/5 14:21
 */
public class Num435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return 0;
        }

        //按照end升序排序
        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);

        //至少有一个不重复的区间
        int cnt=1;

        //排序后 第一个区间结尾就是x
        int x_end=intervals[0][1];

        for (int[] interval : intervals) {
            int start = interval[0];
            //若是一个区间的start>= 另一个区间的end 则说明两个区间不相交
            if (start >= x_end) {
                //更新计数
                cnt++;
                //更新end
                x_end = interval[1];
            }
        }
        return  cnt;
    }
}
