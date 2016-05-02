package com.chepeatio.binaryTreeMaximumPathSum;

import com.chepeatio.utils.TreeNode;

/**
 * Created by Che Peatio on 2016/4/29.
 */
public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        process(root, res);
        return res[0];
    }

    private int process(TreeNode root, int[] res) {
        int v;
        if (root.left==null && root.right==null) {
            res[0] = res[0] > root.val ? res[0] : root.val;
            return root.val;
        } else if (root.left == null) {
            v = process(root.right, res);
            if (v < 0)
                v = root.val;
            else
                v = root.val + v;
            res[0] = res[0] > v ? res[0] : v;
            return v;
        } else if (root.right == null) {
            v = process(root.left, res);
            if (v < 0)
                v = root.val;
            else
                v = root.val + v;
            res[0] = res[0] > v ? res[0] : v;
            return v;
        } else {
            int left_val = process(root.left, res);
            int right_val = process(root.right, res);
            if (left_val < 0 && right_val < 0)
                v = root.val;
            else if (right_val < 0)
                v = root.val + left_val;
            else if (left_val < 0)
                v = root.val + right_val;
            else
                v = root.val + left_val + right_val;
            res[0] = res[0] > v ? res[0] : v;
            return v==root.val ? root.val : root.val+Math.max(left_val, right_val);
        }
    }
}
