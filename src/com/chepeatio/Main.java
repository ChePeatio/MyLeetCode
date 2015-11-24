package com.chepeatio;

import com.chepeatio.binaryTreeInorderTraversal.BinaryTreeInorderTraversal;
import com.chepeatio.binaryTreeInorderTraversal.TreeNode;
import com.chepeatio.generateParentheses.GenerateParentheses;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello, LeetCode!");
        GenerateParentheses test = new GenerateParentheses();
        List<String> res = test.generateParenthesis(4);
        for (String re : res) {
            System.out.println(re);
        }
    }
}
