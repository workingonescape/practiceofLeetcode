package com.algorithm;

import java.util.List;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/6/2 18:02
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }


    public static TreeNode buildeTreeNode(int[] nums) {
        //注意这里 start为0  end为nums.length
        return sortedArrayToBST(nums,0,nums.length);
    }

    private static TreeNode sortedArrayToBST(int[] nums,int start,int end){
        // start与end相等时说明数组为空，直接返回null
        if(start==end){
            return null;
        }

        //找到数组的中点
        int mid=(start+end)>>1;
        //以中点为根节点创建二叉树
        TreeNode root=new TreeNode(nums[mid]);
        //递归地创建左右子树
        //左子树使用左半部分
        root.left=sortedArrayToBST(nums,start,mid);
        //右子树使用右半部分
        root.right = sortedArrayToBST(nums, mid + 1, end);


        //返回创建好的二叉树
        return root;
    }
}
