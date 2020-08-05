package com.algorithm.leetcode.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/8/5 14:58
 */
public class Num406 {

    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }

        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        List<int[]> res = new ArrayList<>();

        for (int[] p : people) {
            //按照k进行插入
            res.add(p[1], p);
        }

        return res.toArray(new int[res.size()][]);
    }

}
