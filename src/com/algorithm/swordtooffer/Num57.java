package com.algorithm.swordtooffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/6/7 18:25
 */
public class Num57 {
    public int[][] findContinuousSequence(int target) {
        int left=1;
        int right=2;

        int sum=left+right;

        List<int[]> res = new ArrayList<>();

        while (left < right && right < target) {
            if (sum > target) {
                sum-=left;
                left++;
            }else if (sum<target){
                right++;
                sum+=right;
            }else{
                int[] sub = new int[right - left + 1];
                int i=0,j=left;
                while (i < right - left + 1) {
                    sub[i]=j;
                    i++;
                    j++;
                }
                res.add(sub);
                sum-=left;
                left++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
