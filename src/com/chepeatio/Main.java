package com.chepeatio;

import com.chepeatio.spiralMatrix.SpiralMatrixII;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello, LeetCode!");
        SpiralMatrixII test = new SpiralMatrixII();
        int[][] arr = test.generateMatrix(1);
        for (int i=0; i<1; i++) {
            for (int j=0; j<1; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        int[][] arr1 = test.generateMatrix(0);
        System.out.println("Length: " + arr1.length);
    }
}
