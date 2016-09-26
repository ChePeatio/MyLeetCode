package com.chepeatio.rotateImage;

/**
 * Created by Che Peatio on 2015/12/7.
 */
public class RotateImage {

    /**
     * In-place solution: 先转置矩阵，后每行翻转即可
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int temp;
        for (int x=0; x<matrix.length; x++) {
            for (int y=x+1; y<matrix.length; y++) {
                temp = matrix[x][y];
                matrix[x][y] = matrix[y][x];
                matrix[y][x] = temp;
            }
        }
        for (int x=0; x<matrix.length; x++) {
            for (int y=0; y<matrix.length/2; y++) {
                temp = matrix[x][y];
                matrix[x][y] = matrix[x][matrix.length-1-y];
                matrix[x][matrix.length-1-y] = temp;
            }
        }
    }

    public void rotateOut_Place(int[][] matrix) {
        if (matrix == null || matrix.length==0)
            return;
        int[][] temp = new int[matrix.length][matrix.length];
        for (int x=0; x<matrix.length; x++) {
            for (int y=0; y<matrix.length; y++) {
                temp[y][matrix.length-x-1] = matrix[x][y];
            }
        }
        for (int x=0; x<matrix.length; x++) {
            System.arraycopy(temp[x], 0, matrix[x], 0, matrix.length);
        }
    }
}
