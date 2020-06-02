package com.algorithm.swordtooffer;

import com.algorithm.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/6/2 18:00
 */
public class Num37 {

    public String serialize(TreeNode root) {
        if(root==null){
            return "";
        }
        StringBuilder sb=new StringBuilder();

        order(sb,root);

        return sb.substring(0,sb.length()-1);
    }

    private void order(StringBuilder sb, TreeNode root){
        if(root==null){
            sb.append("null");

            return;
        }

        sb.append(root.val);
        sb.append(",");
        order(sb,root.left);
        order(sb,root.right);
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(8));
        System.out.println(Integer.toBinaryString(~8));
        System.out.println(Integer.toBinaryString(~8 + 1));
    }
}
