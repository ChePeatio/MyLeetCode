package com.chepeatio.binarySearchTreeIterator;

import com.chepeatio.binaryTreeStructure.TreeNode;

import java.util.Stack;

/**
 * Created by Che Peatio on 2015/12/23.
 */
public class BinarySearchTreeIterator {
    Stack<TreeNode> stack;
    public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();
        if (root!=null) {
            stack.push(root);
            TreeNode temp = stack.peek();
            while (temp.left != null) {
                stack.push(temp.left);
                temp = stack.peek();
            }
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.empty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode res = stack.pop();
        TreeNode temp = res.right;
        while (temp!=null) {
            stack.push(temp);
            temp = temp.left;
        }
        return res.val;
    }
}
