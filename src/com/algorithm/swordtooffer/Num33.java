package com.algorithm.swordtooffer;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/8/10 21:53
 */
public class Num33 {


    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return true;
        }

        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    private boolean verifyPostorder(int[] postorder, int start, int end) {
        if (postorder == null || postorder.length == 0) {
            return false;
        }

        //说明子树只有一个节点
        if (start >= end) {
            return true;
        }

        int cursor = start;

        //对于后续遍历来说，根节点是最后一个被遍历到的位置
        // 所有左子树小于根节点
        while (postorder[cursor] < postorder[end]) {
            cursor++;
        }

        //找到第一个不小于根节点的位置 说明左子树已经遍历完成
        // 下面开始遍历右子树，但要先保存一下这个位置 后面有用
        int mid = cursor;

        while (postorder[cursor] > postorder[end]) {
            cursor++;
        }

        return cursor == end && verifyPostorder(postorder, start, mid - 1) && verifyPostorder(postorder, mid, end - 1);
    }


    public static void main(String[] args) {
        int[] postorder = new int[]{1, 3, 2, 6, 5};

        new Num33().verifyPostorder(postorder);
    }
}
