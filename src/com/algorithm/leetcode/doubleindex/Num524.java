package com.algorithm.leetcode.doubleindex;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/8/3 16:47
 */
public class Num524 {


    public String findLongestWord(String s, List<String> d) {
        if (s == null || s.length() == 0 || d == null || d.size() == 0) {
            return "";
        }

        String res = "";
        Collections.sort(d);




        for (String subs : d) {
            if (isSub(s, subs) && subs.length() > res.length()) {
                res = subs;
            }
        }

        return res;
    }

    private boolean isSub(String target, String subs) {
        int i = 0, j = 0;
        while (i < target.length() && j < subs.length()) {
            if (target.charAt(i) == subs.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == subs.length();
    }
}
