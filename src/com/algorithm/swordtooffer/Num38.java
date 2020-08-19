package com.algorithm.swordtooffer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/8/12 16:49
 */
public class Num38 {


    private Set<String> res = new HashSet<>();

    public String[] permutation(String s) {
        if (s == null || s.length() == 0) {
            return new String[0];
        }

        boolean[] visited = new boolean[s.length()];

        backTrace(s, "", visited);

        return res.toArray(new String[res.size()]);
    }

    private void backTrace(String s, String curPath, boolean[] visited) {
        if (s.length() == curPath.length()) {
            res.add(curPath);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            backTrace(s, curPath + s.charAt(i), visited);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        new Num38().permutation("abc");
    }
}
