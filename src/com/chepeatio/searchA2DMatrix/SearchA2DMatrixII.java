package com.chepeatio.searchA2DMatrix;

/**
 * Created by Che Peatio on 2015/12/26.
 */
public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix==null || matrix.length==0)
            return false;
        int x1=0, y1=0, x2=matrix.length-1, y2=matrix[0].length-1;
        while (true) {
            while (y1 <= y2) {
                if (matrix[x2][y1] == target) {
                    return true;
                } else if (matrix[x2][y1] < target) {
                    y1++;
                } else {
                    break;
                }
            }
            if (y1 > y2) {
                return false;
            }

            while (y1 <= y2) {
                if (matrix[x1][y2] == target) {
                    return true;
                } else if (matrix[x1][y2] > target) {
                    y2--;
                } else {
                    break;
                }
            }
            if (y1 > y2) {
                return false;
            }

            while (x1 <= x2) {
                if (matrix[x2][y1] == target) {
                    return true;
                } else if (matrix[x2][y1] > target) {
                    x2--;
                } else {
                    break;
                }
            }
            if (x1 > x2) {
                return false;
            }

            while (x1 <= x2) {
                if (matrix[x1][y2] == target) {
                    return true;
                } else if (matrix[x1][y2] < target) {
                    x1++;
                } else {
                    break;
                }
            }
            if (x1 > x2) {
                return false;
            }
        }
    }
}
