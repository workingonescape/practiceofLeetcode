package com.algorithm.swordtooffer;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/8/12 17:34
 */
public class Num58 {

    public String reverseWords(String s) {
        if(s==null || s.length()==0){
            return "";
        }

        s = s.trim();

        String[] strs=s.split(" ");

        StringBuilder sb=new StringBuilder();

        for(int i=strs.length-1;i>=0;i--){
            if (!strs[i].equals("")){
                sb.append(strs[i]);
                if(i>0){
                    sb.append(" ");
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        new Num58().reverseWords("a good   example");
    }
}
