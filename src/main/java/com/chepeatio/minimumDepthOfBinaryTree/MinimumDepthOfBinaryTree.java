package com.chepeatio.minimumDepthOfBinaryTree;

import com.chepeatio.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Che Peatio on 2016/1/8.
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int min = 1, levelCount = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tn = queue.poll();
            if (tn.left==null && tn.right==null) {
                return min;
            } else {
                if (tn.left != null)
                    queue.add(tn.left);
                if (tn.right != null)
                    queue.add(tn.right);
                if (levelCount == 1) {
                    levelCount = queue.size();
                    min++;
                } else {
                    levelCount--;
                }
            }
        }
        return min;
    }

    /**
     * Recursive solution. Such problems using recursive solution will have a better efficient.
     * @param root of binary tree
     * @return min depth
     */
    public int recursiveMinDepth(TreeNode root) {
        if (root == null)
            return 0;
        else {
            if (root.left != null && root.right != null) {
                return Math.min(recursiveMinDepth(root.left), recursiveMinDepth(root.right)) + 1;
            } else {
                return Math.max(recursiveMinDepth(root.left), recursiveMinDepth(root.right)) + 1;
            }
        }
    }

    public TreeNode generateTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        return root;
    }
}
