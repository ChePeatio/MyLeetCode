package com.chepeatio.invertBinaryTree;

/**
 * Created by Che Peatio on 2015/10/26.
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
