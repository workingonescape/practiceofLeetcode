package com.algorithm.leetcode.numric;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/5/22 23:25
 */
public class Num8 {


//    public int myAtoi(String str) {
//        char[] chars = str.toCharArray();
//        int n = chars.length;
//        int idx = 0;
//        while (idx < n && chars[idx] == ' ') {
//            // 去掉前导空格
//            idx++;
//        }
//        if (idx == n) {
//            //去掉前导空格以后到了末尾了
//            return 0;
//        }
//        boolean negative = false;
//        if (chars[idx] == '-') {
//            //遇到负号
//            negative = true;
//            idx++;
//        } else if (chars[idx] == '+') {
//            // 遇到正号
//            idx++;
//        }
//        int ans = 0;
//        while (idx < n && isDigit(chars[idx])) {
//            int digit = chars[idx] - '0';
//            //前面去掉了 + - 号 所以这里直接 使用Integer.MAX_VALUE进行判断
//            if (ans > (Integer.MAX_VALUE - digit) / 10) {
//                // 本来应该是 ans * 10 + digit > Integer.MAX_VALUE
//                // 但是 *10 和 + digit 都有可能越界，所有都移动到右边去就可以了。
//                return negative? Integer.MIN_VALUE : Integer.MAX_VALUE;
//            }
//            ans = ans * 10 + digit;
//            idx++;
//        }
//        return negative? -ans : ans;
//    }

    public int myAtoi(String str) {
        if(str==null || str.length()==0){
            return 0;
        }

        int len=str.length();

        char[] chars=str.toCharArray();

        int index=0;

        while (index < len && chars[index] == ' ') {
            index++;
        }

        if(index==len){
            return 0;
        }

        boolean negative=false;

        if(chars[index]=='-'){
            negative=true;
            index++;
        }else if(chars[index]=='+'){
            index++;
        }

        int res=0;

        while(index <len  && isdigit(chars[index])){
            int cur=chars[index]-'0';
            if(res>(Integer.MAX_VALUE-cur)/10){
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res=res*10+cur;
            index++;
        }

        return negative==true?-res:res;
    }


    private boolean isdigit(char ch){
        return ch>='0' && ch<='9';
    }

//    private boolean isDigit(char ch) {
//        return ch >= '0' && ch <= '9';
//    }

    public static void main(String[] args) {
        String s = "2147483646";

        new Num8().myAtoi(s);
    }
}
