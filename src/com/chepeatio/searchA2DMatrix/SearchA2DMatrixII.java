package com.chepeatio.searchA2DMatrix;

/**
 * Created by Che Peatio on 2015/12/26.
 */
public class SearchA2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length, x=m-1, y=0;
        while(y<n && x>=0) {
            if (matrix[x][y]<target)
                y++;
            else if (matrix[x][y]>target)
                x--;
            else
                return true;
        }
        return false;
    }

    /**
     * O(m+n) but long ugly solution
     * @param matrix the matrix
     * @param target the target
     * @return whether there is a target in the matrix
     */
    public boolean searchMatrixUglySolution(int[][] matrix, int target) {
        if (matrix==null || matrix.length==0)
            return false;
        int x1=0, y1=0, x2=matrix.length-1, y2=matrix[0].length-1;
        while (true) {
            while (y1 <= y2) {
                if (matrix[x2][y1] < target) {
                    y1++;
                } else if (matrix[x2][y1] > target) {
                    break;
                } else {
                    return true;
                }
            }

            while (y1 <= y2) {
                if (matrix[x1][y2] > target) {
                    y2--;
                } else if (matrix[x1][y2] < target) {
                    break;
                } else {
                    return true;
                }
            }
            if (y1 > y2) {
                return false;
            }

            while (x1 <= x2) {
                if (matrix[x2][y1] > target) {
                    x2--;
                } else if (matrix[x2][y1] < target) {
                    break;
                } else {
                    return true;
                }
            }

            while (x1 <= x2) {
                if (matrix[x1][y2] < target) {
                    x1++;
                } else if (matrix[x1][y2] > target) {
                    break;
                } else {
                    return true;
                }
            }
            if (x1 > x2) {
                return false;
            }
        }
    }
}
