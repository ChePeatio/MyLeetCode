package com.chepeatio.setMatrixZeroes;

import java.util.Arrays;

/**
 * Created by Che Peatio on 2015/12/18.
 */
public class SetMatrixZeroes {

    /**
     * Constant space solution using first row.
     * @param matrix input
     */
    public void setZeroes(int[][] matrix) {
        if (matrix==null || matrix.length==0)
            return;

        int lenX = matrix.length;
        int lenY = matrix[0].length;
        int x, y, flag=0;

        // judge if matrix[0] has '0'.
        while (flag<lenY && matrix[0][flag]!=0) flag++;

        // search '0' element and set in first row and first column
        for (x=1; x<lenX; x++) {
            for (y=0; y<lenY; y++) {
                if (matrix[x][y] == 0) {
                    matrix[x][0] = matrix[0][y] = 0;
                }
            }
        }

        // set zeroes
        for (x=1; x<lenX; x++) {
            if (matrix[x][0] == 0) {
                Arrays.fill(matrix[x], 0);
            } else {
                for (y=0; y<lenY; y++) {
                    if (matrix[0][y]==0) {
                        matrix[x][y] = 0;
                    }
                }
            }
        }

        // if row0 has '0', then set zeroes.
        if (flag < lenY)
            Arrays.fill(matrix[0], 0);
    }

    /**
     * O(m+n) space solution
     * @param matrix input
     */
    public void setZeroesOMN(int[][] matrix) {
        if (matrix==null || matrix.length==0)
            return;

        int lenX = matrix.length;
        int lenY = matrix[0].length;
        int[] row = new int[lenX];
        int[] column = new int[lenY];
        for (int x=0; x<lenX; x++) {
            for (int y=0; y<lenY; y++) {
                if (matrix[x][y] == 0) {
                    row[x] = 1;
                    column[y] = 1;
                }
            }
        }

        for (int x=0; x<lenX; x++) {
            if (row[x] != 0) {
                for (int y = 0; y < lenY; y++) {
                    matrix[x][y] = 0;
                }
            }
        }
        for (int y=0; y<lenY; y++) {
            if (column[y] != 0) {
                for (int x = 0; x < lenX; x++) {
                    matrix[x][y] = 0;
                }
            }
        }
    }
}
