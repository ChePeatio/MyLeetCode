package com.chepeatio.wordSearch;

/**
 * Created by Che Peatio on 2016/6/12.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {

        if (word == null || word.length() == 0)
            return true;
        if (board==null || board.length==0 || board[0].length==0)
            return false;

        char[][] matrix = new char[board.length][board[0].length];
        for (int i=0; i<board.length; i++) {
            matrix[i] = board[i].clone();
        }
        char[] chs = word.toCharArray();
        int[][] movement = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
        for (int x=0; x<matrix.length; x++) {
            for (int y=0; y<matrix[x].length; y++) {
                if (chs[0] == matrix[x][y]) {
                    matrix[x][y] = '.';
                    if (travelAllPosition(board, matrix, x, y, chs, 1, movement))
                        return true;
                    matrix[x][y] = board[x][y];
                }
            }
        }
        return false;
    }

    private boolean travelAllPosition(char[][] board, char[][] matrix, int x, int y,
                                      char[] chs, int pos, int[][] movement) {
        if (pos == chs.length)
            return true;

        for (int i=0; i<4; i++) {
            int x1 = x + movement[i][0];
            int y1 = y + movement[i][1];
            if (x1>=0 && x1<matrix.length && y1>=0 && y1<matrix[0].length) {
                if (matrix[x1][y1] == chs[pos]) {
                    matrix[x1][y1] = '.';
                    if (travelAllPosition(board, matrix, x1, y1, chs, pos+1, movement))
                        return true;
                    matrix[x1][y1] = board[x1][y1];
                }
            }
        }
        return false;
    }
}
