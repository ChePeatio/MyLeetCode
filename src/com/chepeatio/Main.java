package com.chepeatio;

import com.chepeatio.burstBalloons.BurstBalloons;
import com.chepeatio.minimumDepthOfBinaryTree.MinimumDepthOfBinaryTree;
import com.chepeatio.subsets.Subsets;
import com.chepeatio.superUglyNumber.SuperUglyNumber;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello, LeetCode!");
        SuperUglyNumber test = new SuperUglyNumber();
        test.nthSuperUglyNumber(12, new int[]{2,7,13,19});
    }
}
