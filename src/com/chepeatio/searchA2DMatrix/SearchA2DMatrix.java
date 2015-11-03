package com.chepeatio.searchA2DMatrix;

/**
 * Created by Che Peatio on 2015/11/3.
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0)
            return false;
        for (int i=matrix.length-1; i>-1; i--) {
            if (matrix[i][0] <= target) {
                for (int num : matrix[i]) {
                    if (num == target)
                        return true;
                    if (num > target)
                        return false;
                }
                break;
            }
        }
        return false;
    }
}
