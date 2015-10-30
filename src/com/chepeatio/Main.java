package com.chepeatio;

import com.chepeatio.maximumProductSubarray.MaximumProductSubarray;
import com.chepeatio.spiralMatrix.SpiralMatrixII;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello, LeetCode!");
        int[] param = new int[]{2,-3,4,-5};
        MaximumProductSubarray test = new MaximumProductSubarray();
        System.out.println(test.maxProductBS(param));
    }
}
