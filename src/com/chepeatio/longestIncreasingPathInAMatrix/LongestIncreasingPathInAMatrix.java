package com.chepeatio.longestIncreasingPathInAMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Che Peatio on 2016/2/22.
 */
public class LongestIncreasingPathInAMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        int result = 0;

        if (matrix.length!=0 && matrix[0].length!=0) {

            List<Integer> list = new ArrayList<>();
            for (int x = 0; x < matrix.length; x++) {
                for (int y = 0; y < matrix[0].length; y++) {
                    if (beStartPoint(x,y,matrix)) {
                        list.add(x);
                        list.add(y);
                    }
                }
            }

            int[] longestLength = new int[2];
            longestLength[0] = 1;
            int listLength = list.size() / 2;
            for (int i=0; i<listLength; i++) {
                int x = list.get(i*2);
                int y = list.get(i*2+1);
                findLongestLength(matrix, x, y, longestLength);
            }
            result = longestLength[1];
        }

        return result;
    }

    private boolean beStartPoint(int x, int y, int[][] matrix) {
        if (x-1>=0 && matrix[x][y]>matrix[x-1][y])
            return false;
        else if (x+1<matrix.length && matrix[x][y]>matrix[x+1][y])
            return false;
        else if (y-1>=0 && matrix[x][y]>matrix[x][y-1])
            return false;
        else if (y+1<matrix[0].length && matrix[x][y]>matrix[x][y+1])
            return false;
        else
            return true;
    }

    private void findLongestLength(int[][] matrix, int x, int y, int[] longestLength) {
        if (x-1>=0 && matrix[x][y]<matrix[x-1][y]) {
            longestLength[0]++;
            findLongestLength(matrix, x-1, y, longestLength);
            longestLength[0]--;
        }
        if (x+1<matrix.length && matrix[x][y]<matrix[x+1][y]) {
            longestLength[0]++;
            findLongestLength(matrix, x+1, y, longestLength);
            longestLength[0]--;
        }
        if (y-1>=0 && matrix[x][y]<matrix[x][y-1]) {
            longestLength[0]++;
            findLongestLength(matrix, x, y-1, longestLength);
            longestLength[0]--;
        }
        if (y+1<matrix[0].length && matrix[x][y]<matrix[x][y+1]) {
            longestLength[0]++;
            findLongestLength(matrix, x, y+1, longestLength);
            longestLength[0]--;
        }
        if (longestLength[0] > longestLength[1])
            longestLength[1] = longestLength[0];
    }
}
