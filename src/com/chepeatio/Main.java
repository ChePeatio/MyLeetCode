package com.chepeatio;

import com.chepeatio.utils.TreeNode;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello, LeetCode!");

        TreeNode root = TreeNode.generateTree("1,2,3,#,#,4,#,#,5");
        TreeNode.printTree(root);

        root = TreeNode.generateTree("1,2,3,4,5,6,7,8,9,10");
        TreeNode.printTree(root);
    }
}
