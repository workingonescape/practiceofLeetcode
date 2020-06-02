package com.algorithm.leetcode.treenode;

import com.algorithm.TreeNode;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/6/3 0:26
 */
public class Num235 {
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }

        // p,q均在右子树上，所以接着在右子树上寻找
        if(p.val>root.val && q.val>root.val){
            return lowestCommonAncestor(root.right,p,q);
            //p,q均在左子树上，所以接着在左子树上寻找
        }else if(p.val<root.val && q.val<root.val){
            return lowestCommonAncestor(root.left,p,q);
        }

        // 说明p,q分别位于根节点的左右子树上，此时根节点就是最近公共祖先
        return root;
    }
}
