package com.chepeatio.spiralMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Che Peatio on 2016/5/24.
 */
public class SpiralMatrix {

    /**
     * This version used several tricks to speed up the normal solution.
     * @param matrix int[][]
     * @return list
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        if (matrix==null || matrix.length==0 || matrix[0].length==0)
            return res;

        int state = 0;
        int[][] dirs = new int[4][];
        dirs[0] = new int[]{0,1};
        dirs[1] = new int[]{1,0};
        dirs[2] = new int[]{0,-1};
        dirs[3] = new int[]{-1,0};
        int row = matrix.length;
        int column = matrix[0].length;
        int count, x=0, y=-1;

        while (row>0 && column>0) {
            count = (state&1)==0 ? column : row;
            for (int i=0; i<count; i++) {
                x += dirs[state][0];
                y += dirs[state][1];
                res.add(matrix[x][y]);
            }
            if ((state&1)==0) {
                row--;
            } else {
                column--;
            }
            state = (state+1) & 3;
        }

        return res;
    }
}
