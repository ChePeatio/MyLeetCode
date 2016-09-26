package com.chepeatio.kthSmallestElementInaBST;

/**
 * Created and Finished by Che Peatio on 2015/11/26.
 */
public class KthSmallestElementInaBST {

    int ans = 0;

    public int kthSmallest(TreeNode root, int k) {
        TreeNode x = new TreeNode(k);
        helper(root, x);
        return ans;
    }

    public void helper(TreeNode root, TreeNode x) {
        if (root == null || x.val < 0) return;

        helper(root.left, x);
        x.val--;
        if (x.val == 0) {
            ans = root.val;
            return;
        }
        helper(root.right, x);
    }

    public TreeNode generateTree() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        return root;
    }
}
