package com.algorithm.swordtooffer;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/8/13 16:13
 */
public class Num16 {

    public double myPow(double x, int n) {
        long b=n;
        return cal(x,b);

    }


    public double cal(double x, long n) {

        if (n == 0) {
            return 1;
        }

        if(n<0){
            return 1/cal(x,-n);
        }else if((n&1)==1){
            return cal(x,n-1)*x;
        }else{
            double temp=cal(x,n/2);
            return temp*temp;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Num16().myPow(2.0, -2));;
    }
}
