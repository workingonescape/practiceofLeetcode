package com.algorithm.swordtooffer;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/6/5 0:47
 */
public class Num29 {

    public int[] spiralOrder(int[][] matrix) {
        if(matrix==null || matrix.length==0){
            return null;
        }


        int left=0;
        int right=matrix[0].length-1;
        int top=0;
        int bottom=matrix.length-1;

        int size=matrix.length*matrix[0].length;

        int[] res=new int[size];

        int index=0;

        while(index<size){
            for(int i=left;i<=right && index<size ;i++){
                res[index]=matrix[top][i];
                index++;
            }
            top++;
            for(int i=top;i<=bottom && index<size ;i++){
                res[index]=matrix[i][right];
                index++;
            }
            right--;

            for(int i=right;i>=left && index<size ;i--){
                res[index]=matrix[bottom][i];
                index++;
            }

            bottom--;

            for(int i=bottom;i>=top && index<size ;i--){
                res[index]=matrix[i][left];
                index++;
            }

            left++;

        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        new Num29().spiralOrder(matrix);
    }
}
