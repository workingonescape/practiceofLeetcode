package com.algorithm.swordtooffer;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/8/15 1:38
 */
public class Num13 {

//    int count=0;
//
//    int M=0;
//    int N=0;
//
//
//    public int movingCount(int m, int n, int k) {
//
//        boolean[][] visited = new boolean[m][n];
//        M=m;
//        N=n;
//        dfs(0, 0, k, visited);
//        return count;
//    }
//
//    private void dfs(int i, int j, int k, boolean[][] visited) {
//        if (i<0 || i>=M||j<0 || j>=N || visited[i][j] || sum(i,j)>k){
//            return;
//        }
//        count++;//当前已经遍历到[i][j]位置
//        visited[i][j] = true;
//        dfs(i + 1, j, k, visited);
//        dfs(i, j + 1, k, visited);
//    }
//
//    private int sum(int i, int j) {
//        int res = 0;
//        while (i != 0) {
//            res+=i%10;
//            i/=10;
//        }
//
//        while (j != 0) {
//            res+=j%10;
//            j /= 10;
//        }
//        return res;
//    }

    int M=0;
    int N=0;

    public int movingCount(int m, int n, int k) {

        M=m;
        N=n;
        boolean[][] visited=new boolean[m][n];
        return dfs(0,0,k,visited);

    }


    private int  dfs(int i,int j,int k,boolean[][] visited){
        if( i>=M || j>=N || visited[i][j] || sum(i,j)>k){
            return 0;
        }
        visited[i][j]=true;
        return 1+dfs(i+1,j,k,visited)+dfs(i,j+1,k,visited);
    }

    private int sum(int i,int j){
        int res=0;

        while(i!=0){
            res+=i%10;
            i/=10;
        }

        while(j!=10){
            res+=j%10;
            j/=10;
        }

        return res;
    }

    public static void main(String[] args) {
        new Num13().movingCount(2, 3, 1);
    }
}
