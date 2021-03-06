package com.algorithm.swordtooffer;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/6/5 0:05
 */
public class Num67 {

//    public int strToInt(String str) {
//        int index=0;
//        int len=str.length();
//        char[] chars=str.toCharArray();
//
//        while(index<len && chars[index]==' '){
//            index++;
//        }
//
//        boolean negative=false;
//
//        if(chars[index]=='+'){
//            index++;
//        }else if(chars[index]=='-'){
//            negative=true;
//            index++;
//        }
//
//        int res=0;
//
//        while(index<len && isDigit(chars[index])){
//            int temp=chars[index]-'0';
//            if(res>(Integer.MAX_VALUE-temp)/10){
//                return negative?-Integer.MAX_VALUE:Integer.MAX_VALUE;
//            }
//            res=res*10+temp;
//            index++;
//        }
//
//        return res;
//    }
//
//    private boolean isDigit(char ch){
//        return ch>='0' && ch<='9';
//    }

    public int strToInt(String str) {
        if(str==null || str.length()==0){
            return Integer.MIN_VALUE;
        }

        char[] chars=str.toCharArray();

        int len=chars.length;

        int index=0;

        while(index<len && chars[index]==' '){
            index++;
        }

        if(index==len){
            return Integer.MIN_VALUE;
        }

        boolean negative=false;

        if(chars[index]=='-'){
            negative=true;
            index++;
        }

        int res=0;

        while(index<len && isDigit(chars[index])){
            int value=chars[index]-'0';

            if(res>Integer.MAX_VALUE || res>(Integer.MAX_VALUE-value)/10 ){
                return negative?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            res=res*10+value;
        }

        return negative?(-1*res):res;
    }

    private boolean isDigit(char ch){
        return '0'<=ch && ch<='9' ;
    }

    public static void main(String[] args) {
        String str = "42";
        new Num67().strToInt(str);
    }
}
