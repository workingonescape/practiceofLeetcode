package com.algorithm.leetcode.doubleindex;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/8/3 14:42
 */
public class Num680 {

    public boolean validPalindrome(String s) {
        if(s==null || s.length()==0){
            return true;
        }

        int l=0;
        int r=s.length()-1;

        while(l<=r){
            if(s.charAt(l)!=s.charAt(r)){
                return isPalindrome(s,l,r-1) || isPalindrome(s,l+1,r);
            }else{
                l++;
                r--;
            }
        }

        return true;
    }

    private boolean isPalindrome(String s,int l,int r){
        while(l<=r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }else{
                l++;
                r--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Num680().validPalindrome("aba");
    }
}
