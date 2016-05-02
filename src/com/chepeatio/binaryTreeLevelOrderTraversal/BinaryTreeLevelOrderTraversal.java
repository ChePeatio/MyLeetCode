package com.chepeatio.binaryTreeLevelOrderTraversal;

import com.chepeatio.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Che Peatio on 2016/1/1.
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int rest = 1;
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode tn = queue.poll();
            if (tn.left != null) {
                queue.add(tn.left);
            }
            if (tn.right != null) {
                queue.add(tn.right);
            }
            list.add(tn.val);
            if (rest == 1) {
                rest = queue.size();
                res.add(list);
                list = new ArrayList<>();
            } else {
                rest--;
            }
        }
        return res;
    }
}
