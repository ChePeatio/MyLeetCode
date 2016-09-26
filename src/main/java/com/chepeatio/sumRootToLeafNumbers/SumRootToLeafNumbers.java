package com.chepeatio.sumRootToLeafNumbers;

import com.chepeatio.utils.TreeNode;

/**
 * Created by Che Peatio on 2015/12/29.
 * Edited by Che Peatio on 2016/04/29.
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        int[] res = new int[1];
        if (root != null)
            dfsSumNumbers(root, 0, res);
        return res[0];
    }

    private void dfsSumNumbers(TreeNode root, int cur, int[] res) {
        cur = cur * 10 + root.val;
        if (root.left!=null && root.right!=null) {
            dfsSumNumbers(root.left, cur, res);
            dfsSumNumbers(root.right, cur, res);
        } else if (root.left!=null) {
            dfsSumNumbers(root.left, cur, res);
        } else if (root.right!=null) {
            dfsSumNumbers(root.right, cur, res);
        } else {
            res[0] += cur;
        }
    }
}
