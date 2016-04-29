package com.chepeatio.binaryTreePostorderTraversal;

import com.chepeatio.binaryTreeStructure.TreeNode;

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
}
