package com.chepeatio.balancedBinaryTree;

import com.chepeatio.binaryTreeStructure.TreeNode;

/**
 * Created by Che Peatio on 2015/12/9.
 * Edited by Che Peatio on 2016/04/29.
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return height(root)!=-1;
    }
    public int height(TreeNode p){
        if (p == null)
            return 0;
        int left = height(p.left);
        int right = height(p.right);
        if (left==-1 || right==-1) {
            return -1;
        } else if(Math.abs(left-right) <= 1) {
            return Math.max(left,right)+1;
        } else {
            return -1;
        }
    }

    public boolean isBalancedUgly(TreeNode root) {
        if (root == null) {
            return true;
        } else if (root.left==null && root.right==null) {
            root.val = 1;
            return true;
        } else if (isBalanced(root.left) && isBalanced(root.right)) {
            if (root.left == null && root.right!=null) {
                if (root.right.val == 1) {
                    root.val = 2;
                    return true;
                } else {
                    return false;
                }
            } else {
                if (root.left!=null && root.right==null) {
                    if (root.left.val == 1) {
                        root.val = 2;
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    int diff = root.left.val - root.right.val;
                    if (diff<=1 && diff>=-1) {
                        root.val = 1 + (root.left.val > root.right.val ? root.left.val : root.right.val);
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public TreeNode generateTree() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(0);
        root.right.left.left = new TreeNode(0);
        root.right.left.right = new TreeNode(0);
        return root;
    }
}
