package com.chepeatio.minimumPathSum;

/**
 * Created by Che Peatio on 2015/12/4.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid==null || grid.length==0 || grid[0].length==0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] list = new int[n];

        list[0] = grid[0][0];
        for (int i=1; i<n; i++) {
            list[i] = list[i-1] + grid[0][i];
        }

        int temp;
        for (int x=1; x<m; x++) {
            list[0] += grid[x][0];
            for (int y=1; y<n; y++) {
                temp = list[y-1] < list[y] ? list[y-1] : list[y];
                list[y] = grid[x][y] + temp;
            }
        }
        return list[n-1];
    }
}
