package com.chepeatio;

import com.chepeatio.binaryTreeInorderTraversal.BinaryTreeInorderTraversal;
import com.chepeatio.binaryTreeInorderTraversal.TreeNode;
import com.chepeatio.binaryTreePostorderTraversal.BinaryTreePostorderTraversal;
import com.chepeatio.generateParentheses.GenerateParentheses;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello, LeetCode!");
        BinaryTreePostorderTraversal test = new BinaryTreePostorderTraversal();
        List<Integer> res = test.postorderTraversal(test.generateTree());
        for (int num : res) {
            System.out.println(num);
        }
    }
}
