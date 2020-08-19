package com.algorithm.swordtooffer;

import com.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/8/17 20:53
 */
public class Num54 {


    List<Integer> list=new ArrayList<>();
    public int kthLargest(TreeNode root, int k) {
        if(root==null){
            return -1;
        }

        treeToArray(root);

        PriorityQueue<Integer> queue=new PriorityQueue<>((o1, o2) -> o2-o1);


        for(int i=0;i<list.size();i++){
            queue.offer(list.get(i));
            if(queue.size()>k){
                queue.poll();
            }
        }

        return queue.peek();
    }

    private void treeToArray(TreeNode root){
        if(root==null){
            return ;
        }
        treeToArray(root.left);
        list.add(root.val);
        treeToArray(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.buildeTreeNode(new int[]{3, 1, 4, 2});
        new Num54().kthLargest(root, 1);
    }
}
