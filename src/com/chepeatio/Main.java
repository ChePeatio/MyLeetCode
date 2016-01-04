package com.chepeatio;

import com.chepeatio.pathSum.PathSum;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello, LeetCode!");
        PathSum test = new PathSum();
        if (test.hasPathSum(test.generateTree(), 22))
            System.out.println("hehe");
        else
            System.out.println("nono");
    }
}
