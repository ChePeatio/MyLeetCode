package com.chepeatio.binaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Che Peatio on 2015/11/25.
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.addAll(postorderTraversal(root.left));
        res.addAll(postorderTraversal(root.right));
        res.add(root.val);
        return res;
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
}
