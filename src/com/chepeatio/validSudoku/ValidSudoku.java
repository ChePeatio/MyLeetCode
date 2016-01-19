package com.chepeatio.validSudoku;

/**
 * Created by Che Peatio on 2016/1/19.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int[][] matrix = new int[27][9];
        int index, yPos, zPos;
        for (int x=0; x<9; x++) {
            for (int y=0; y<9; y++) {
                if (board[x][y] == '.')
                    continue;
                yPos = 9 + y;
                zPos = 18 + 3 * (x / 3) + y / 3;
                index = board[x][y] - '1';
                if (matrix[x][index] == 1)
                    return false;
                matrix[x][index] = 1;
                if (matrix[yPos][index] == 1)
                    return false;
                matrix[yPos][index] = 1;
                if (matrix[zPos][index] == 1)
                    return false;
                matrix[zPos][index] = 1;
            }
        }
        return true;
    }
}
