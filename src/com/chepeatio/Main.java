package com.chepeatio;

import com.chepeatio.burstBalloons.BurstBalloons;
import com.chepeatio.minimumDepthOfBinaryTree.MinimumDepthOfBinaryTree;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello, LeetCode!");
        int[] param = new int[]{3,1,5,8};
        BurstBalloons test = new BurstBalloons();
        System.out.println(test.maxCoins(param));
    }
}
