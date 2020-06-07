package com.algorithm.leetcode.treenode;

import com.algorithm.TreeNode;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/6/3 0:27
 */
public class Num236 {
}

class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == q || root == p) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        return root;
    }
}
