package com.chepeatio.longestIncreasingPathInAMatrix;

import com.chepeatio.integerToRoman.IntegerToRoman;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Che Peatio on 2016/2/22.
 */
public class LongestIncreasingPathInAMatrix {

    /**
     * This solution uses DFS to calculate each value and uses DP to reduce the calculating time.
     * @param matrix of integers
     * @return longest increasing path
     */
    public int longestIncreasingPath(int[][] matrix) {
        int result = 0;
        if (matrix==null || matrix.length<1 || matrix[0].length<1)
            return result;
        int[][] cache = new int[matrix.length][matrix[0].length];
        for (int x=0; x<matrix.length; x++) {
            for (int y=0; y<matrix[0].length; y++) {
                result = Math.max(dfs(matrix, cache, Integer.MIN_VALUE, x, y), result);
            }
        }
        return result;
    }

    private int dfs(int[][] matrix, int[][] cache, int min, int x, int y) {
        if (x<0 || x>=matrix.length || y<0 || y>=matrix[0].length)
            return 0;
        if (matrix[x][y] <= min)
            return 0;
        if (cache[x][y] != 0)
            return cache[x][y];

        int a = dfs(matrix, cache, matrix[x][y], x-1, y) + 1;
        int b = dfs(matrix, cache, matrix[x][y], x+1, y) + 1;
        int c = dfs(matrix, cache, matrix[x][y], x, y-1) + 1;
        int d = dfs(matrix, cache, matrix[x][y], x, y+1) + 1;
        cache[x][y] = Math.max(a, Math.max(b, Math.max(c, d))); // most useful part!
        return cache[x][y];
    }

    /**
     * This solution only uses backtracking which may not use suitably, so the effectiveness of the solution can't be good.
     * @param matrix of integers
     * @return longest Increasing Path
     */
    public int longestIncreasingPathTLE(int[][] matrix) {
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
