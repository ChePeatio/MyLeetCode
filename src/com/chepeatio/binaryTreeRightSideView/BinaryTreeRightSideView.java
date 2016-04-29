package com.chepeatio.binaryTreeRightSideView;

import com.chepeatio.binaryTreeStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Che Peatio on 2015/12/27.
 * Edited by Che Peatio on 2016/04/29.
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelCount = 1;
        while (!queue.isEmpty()) {
            if (levelCount == 1) {
                TreeNode tn = queue.remove();
                res.add(tn.val);
                if (tn.left != null)
                    queue.add(tn.left);
                if (tn.right != null)
                    queue.add(tn.right);
                levelCount = queue.size();
            } else {
                TreeNode tn = queue.remove();
                if (tn.left != null)
                    queue.add(tn.left);
                if (tn.right != null)
                    queue.add(tn.right);
                levelCount--;
            }
        }
        return res;
    }
}
