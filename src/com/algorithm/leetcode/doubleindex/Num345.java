package com.algorithm.leetcode.doubleindex;

import java.util.Arrays;
import java.util.List;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/8/3 14:06
 */
public class Num345 {


   static final List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');


    public static String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }

        int l = 0;
        int r = s.length() - 1;
        String result = "";
        while (l <= r) {
            if (vowels.contains(s.charAt(l))) {
                if (vowels.contains(s.charAt(r))) {
                    result = swap(s, l, r);
                    l++;
                    r--;
                }else{
                    r--;
                }
            }else {
                l++;
            }
        }

        return result;
    }

    private static String swap(String s, int l, int r) {
        if (s == null || s.length() == 0) {
            return null;
        }

        char[] chars = s.toCharArray();

        char temp = chars[l];
        chars[l] = chars[r];
        chars[r] = temp;

        return new String(chars);
    }


    public static void main(String[] args) {
        String s = "hello";

        System.out.println(reverseVowels(s));

    }
}
