package com.chepeatio.spiralMatrix;

/**
 * Created by Che Peatio on 2015/10/29.
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        recursiveGenerateMatrix(result, n, 0, 1);
        return result;
    }

    private void recursiveGenerateMatrix(int[][] res, int n, int startPos, int startNum) {
        if (n==1)
            res[startPos][startPos] = startNum;
        else if(n != 0) {
            for (int i=0; i<n-1; i++) {
                res[startPos][startPos+i] = startNum + i;
                res[startPos+i][startPos+n-1] = startNum + n-1 + i;
                res[startPos+n-1][startPos+n-1-i] = startNum + (n-1)*2 + i;
                res[startPos+n-1-i][startPos] = startNum + (n-1)*3 + i;
            }
            startNum += (n-1) * 4;
            recursiveGenerateMatrix(res, n-2, startPos+1, startNum);
        }
    }
}
