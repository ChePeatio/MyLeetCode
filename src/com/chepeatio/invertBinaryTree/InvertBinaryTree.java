package com.chepeatio.invertBinaryTree;

import com.chepeatio.binaryTreeStructure.TreeNode;

/**
 * Created by Che Peatio on 2015/10/26.
 * Edited by Che Peatio on 2016/04/29.
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {

        if (root == null)
            return null;

        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
