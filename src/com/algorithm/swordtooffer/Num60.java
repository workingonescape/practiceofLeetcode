package com.algorithm.swordtooffer;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/8/15 0:38
 */
public class Num60 {


    public double[] twoSum(int n) {

        double[] pre={1.0/6,1.0/6,1.0/6,1.0/6,1.0/6,1.0/6};

        for(int i=2;i<=n;i++){
            double[] temp=new double[5*i+1];
            for(int j=0;i<pre.length;j++){
                for(int k=0;k<6;k++){
                    temp[j+k]+=pre[j]/6;
                }
            }
            pre=temp;
        }

        return pre;
    }

    public static int sum(int i,int j){
        int res=0;

        while(i!=0){
            res+=i%10;
            i/=10;
        }

        while(j!=0){
            res+=j%10;
            j/=10;
        }

        return res;
    }

    public static void main(String[] args) {
//        new Num60().twoSum(2);
        System.out.println(sum(35, 38));

    }
}
