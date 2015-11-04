package com.chepeatio;

import com.chepeatio.binaryTreeInorderTraversal.BinaryTreeInorderTraversal;
import com.chepeatio.binaryTreeInorderTraversal.TreeNode;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello, LeetCode!");
        BinaryTreeInorderTraversal test = new BinaryTreeInorderTraversal();
        TreeNode root = test.generateTree();
        List<Integer> result = test.inorderTraversalRecursive(root);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
