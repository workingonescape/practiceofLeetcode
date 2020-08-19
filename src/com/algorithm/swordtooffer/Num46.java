package com.algorithm.swordtooffer;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/6/9 0:16
 */
public class Num46 {

    public int translateNum(int num) {
        if(num<=9){
            return 1;
        }

        String str=String.valueOf(num);

        int[] dp=new int[str.length()+1];

        dp[0]=1;
        dp[1]=1;

        // i<=str.length()
        for(int i=2;i<=str.length();i++){

            int temp=Integer.parseInt(str.substring(i-2,i));
            if(temp>25 || temp<10){
                dp[i]=dp[i-1];
            }else{
                dp[i]=dp[i-1]+dp[i-2];
            }
        }
        return dp[str.length()];
    }


    public static void main(String[] args) {
        new Num46().translateNum(25);
    }
}
