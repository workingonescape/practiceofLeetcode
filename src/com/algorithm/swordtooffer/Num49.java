package com.algorithm.swordtooffer;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/8/11 16:08
 */
public class Num49 {


//    public int nthUglyNumber(int n) {
//        int[] dp = new int[n];
//
//        int a = 0, b = 0, c = 0;
//
//        dp[0] = 1;
//
//        for (int i = 1; i < n; i++) {
//            int da = dp[a] * 2;
//            int db = dp[b] * 3;
//            int dc = dp[c] * 5;
//
//            dp[i] = Math.min(da, Math.min(db, dc));
//
//            if (dp[i] == da) {
//                a++;
//            }
//            if (dp[i] == db) {
//                b++;
//            }
//            if (dp[i] == dc) {
//                c++;
//            }
//        }
//
//        return dp[n - 1];
//        int[] dp=new int[n];
//
//        int a=0;
//        int b=0;
//        int c=0;
//
//        dp[0]=1;
//
//        for(int i=1;i<n;i++){
//
//            int da=dp[a]*2;
//            int db=dp[b]*3;
//            int dc=dp[c]*5;
//
//            dp[i]=Math.min(da,Math.min(db,dc));
//
//            if(dp[i]==da){
//                a++;
//            }
//            if(dp[i]==db){
//                b++;
//            }
//
//            if(dp[i]==dc){
//                c++;
//            }
//        }
//
//        return dp[n-1];
//    }

        public int nthUglyNumber ( int n){


            int[] dp = new int[n];

            dp[0] = 1;


            int a = 0;
            int b = 0;
            int c = 0;


            for (int i = 1; i < n; i++) {

                int da = dp[a] * 2;
                int db = dp[b] * 3;
                int dc = dp[c] * 5;

                dp[i]=Math.min(da,Math.min(db,dc));

                if (dp[i] == da) {
                    a++;
                }

                if (dp[i] == b) {
                    b++;
                }

                if (dp[i] == c) {
                    c++;
                }
            }

            return dp[n - 1];
        }

        public static void main (String[]args){
            System.out.println(new Num49().nthUglyNumber(10));
            ;
        }
    }
