package com.chepeatio.symmetricTree;

import com.chepeatio.utils.TreeNode;

/**
 * Created by Che Peatio on 2015/12/14.
 * Edited by Che Peatio on 2016/04/29.
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return root == null || recursiveSolution(root.left, root.right, true);
    }

    private boolean recursiveSolution(TreeNode left, TreeNode right, Boolean res) {
        if (left==null && right==null || !res) {
            return res;
        } else if (left==null || right==null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        } else {
            return recursiveSolution(left.left, right.right, true) && recursiveSolution(left.right, right.left, true);
        }
    }
}
