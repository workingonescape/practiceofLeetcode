package com.algorithm.swordtooffer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/8/14 20:12
 */
public class Num48 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int left=0;
        int right=0;
        int max=1;

        Set<Character> set = new HashSet<>();

        while (left < s.length() && right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
            }else{
                set.remove(s.charAt(left++));
            }
            max = Math.max(max, right - left);
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        new Num48().lengthOfLongestSubstring(s);
    }
}
