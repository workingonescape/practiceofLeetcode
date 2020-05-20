package com.algorithm.leetcode.datastructure;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/5/21 1:03
 */
public class Trie {

    /**
     * 前缀树
     */
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode(' ');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur=root;
        for (int i = 0; i <word.length() ; i++) {
            char c = word.charAt(i);
            if (cur.children[c-'a'] == null) {
                cur.children[c-'a'] = new TrieNode(c);
            }
            cur=cur.children[c-'a'];
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) {
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        return cur.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur=root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.children[c - 'a'] == null) {
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        return true;
    }




    //节点由三部分组成  节点值 char val  孩子节点数组 TrieNode[26]  是否是完整单词的标记 isWord
    private class TrieNode{
        char val;
        TrieNode[] children;
        boolean isWord;

        public TrieNode(char val){
            this.val = val;
            this.isWord=false;
            this.children = new TrieNode[26];
        }
    }
}

