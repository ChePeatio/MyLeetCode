package com.chepeatio.lowestCommonAncestorOfaBinarySearchTree;

import com.chepeatio.utils.TreeNode;

/**
 * Created by Che Peatio on 2015/11/2.
 * Edited by Che Peatio on 2016/04/29.
 */
public class LowestCommonAncestorOfaBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = root;
        if ((p.val-root.val)*(q.val-root.val) > 0) {
            if (p.val > root.val)
                result = lowestCommonAncestor(root.right, p, q);
            else
                result = lowestCommonAncestor(root.left, p, q);
        }
        return result;
    }
}
