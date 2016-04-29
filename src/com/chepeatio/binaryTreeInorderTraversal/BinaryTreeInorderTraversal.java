package com.chepeatio.binaryTreeInorderTraversal;

import com.chepeatio.binaryTreeStructure.TreeNode;

import java.util.*;

/**
 * Created by Che Peatio on 2015/11/4.
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> set = new HashSet<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (set.contains(temp)) {
                result.add(temp.val);
            } else {
                set.add(temp);
                if (temp.right != null)
                    stack.push(temp.right);
                if (temp.left == null) {
                    result.add(temp.val);
                } else {
                    set.add(temp);
                    stack.push(temp);
                    stack.push(temp.left);
                }
            }
        }
        return result;
    }

    public TreeNode generateTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        return root;
    }

    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recursiveTraversalTree(result, root);
        return result;
    }

    private void recursiveTraversalTree(List<Integer> res, TreeNode root) {
        if (root != null) {
            recursiveTraversalTree(res, root.left);
            res.add(root.val);
            recursiveTraversalTree(res, root.right);
        }
    }
}
