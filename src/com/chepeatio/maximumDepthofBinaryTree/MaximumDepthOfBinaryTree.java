package com.chepeatio.maximumDepthOfBinaryTree;

import com.chepeatio.binaryTreeStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Che Peatio on 2015/10/21.
 * Edited by Che Peatio on 2016/04/29.
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int result = 1;
        Queue<TreeNode> tree = new LinkedList<>();
        tree.add(root);
        root.val = 1;

        int depth;
        TreeNode temp;
        while (!tree.isEmpty()) {
            temp = tree.remove();
            depth = temp.val;
            if (temp.left != null) {
                temp.left.val = depth + 1;
                tree.add(temp.left);
            }
            if (temp.right != null) {
                temp.right.val = depth + 1;
                tree.add(temp.right);
            }
            if (result < depth) {
                result = depth;
            }
        }
        return result;
    }
}
