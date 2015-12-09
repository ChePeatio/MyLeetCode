package com.chepeatio;

import com.chepeatio.balancedBinaryTree.BalancedBinaryTree;
import com.chepeatio.permutations.Permutations;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello, LeetCode!");
        BalancedBinaryTree test = new BalancedBinaryTree();
        if (test.isBalanced(test.generateTree()))
            System.out.println("is");
        else
            System.out.println("is not");
    }
}
