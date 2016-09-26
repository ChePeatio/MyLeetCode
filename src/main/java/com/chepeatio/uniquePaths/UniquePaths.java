package com.chepeatio.uniquePaths;

/**
 * Created by Che Peatio on 2015/11/20.
 */
public class UniquePaths {

    public  int uniquePaths(int m, int n) {
        if (m==1 || n==1)
            return 1;
        int[][] matrix = new int[m][n];
        matrix[0][1] = 1;
        matrix[1][0] = 1;
        for (int i=2; i<m+n-1; i++) {
            for (int j=0; j<m; j++) {
                if (j==0 && i-j<n)
                    matrix[j][i-j] = matrix[j][i-j-1];
                else if (i-j==0)
                    matrix[j][i-j] = matrix[j-1][i-j];
                else if (i-j<n && j>0 && i-j>0)
                    matrix[j][i-j] =matrix[j-1][i-j] + matrix[j][i-j-1];
            }
        }
        return matrix[m-1][n-1];
    }

    public int uniquePathsBS(int m, int n) {
        int[] line = new int[n];
        for (int y=0; y<n; y++) {
            line[y] = 1;
        }
        for (int x=1; x<m; x++) {
            for (int y=1; y<n; y++) {
                line[y] += line[y-1];
            }
        }
        return line[n-1];
    }

    public int uniquePathsTLE(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        return uniquePaths(m-1, n) + uniquePaths(m, n-1);
    }
}
