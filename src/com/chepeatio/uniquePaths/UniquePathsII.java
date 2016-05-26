package com.chepeatio.uniquePaths;

/**
 * Created by Che Peatio on 2016/5/26.
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid==null || obstacleGrid.length==0 || obstacleGrid[0].length==0 || obstacleGrid[0][0]==1)
            return 0;

        int x = obstacleGrid.length;
        int y = obstacleGrid[0].length;
        for (int i=0; i<x; i++) {
            for (int j=0; j<y; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    if (i==0) {
                        if (j==0) {
                            obstacleGrid[i][j] = 1;
                        } else {
                            obstacleGrid[i][j] = obstacleGrid[i][j-1];
                        }
                    } else {
                        if (j==0) {
                            obstacleGrid[i][j] = obstacleGrid[i-1][j];
                        } else {
                            obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                        }
                    }
                }
            }
        }
        return obstacleGrid[x-1][y-1];
    }
}
