package com.algorithm.swordtooffer;

/**
 * @author Reece Lin
 * @version 1.00
 * @time 2020/6/24 1:04
 */
public class Num12 {


    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }

        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, boolean[][] visited, int i, int j, int k) {
        if (k == word.length()) {
            return true;
        }

        // word.charAt(k)!=board[i][j]
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || word.charAt(k) != board[i][j]) {
            return false;
        }

        visited[i][j] = true;
        boolean res = search(board, word, visited, i + 1, j, k + 1) || search(board, word, visited, i - 1, j, k + 1)
                || search(board, word, visited, i, j + 1, k + 1) || search(board, word, visited, i, j - 1, k + 1);
        visited[i][j] = false;
        return res;
    }


}
