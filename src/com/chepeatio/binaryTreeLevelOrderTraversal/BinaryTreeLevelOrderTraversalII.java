package com.chepeatio.binaryTreeLevelOrderTraversal;

import com.chepeatio.binaryTreeStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Che Peatio on 2015/12/19.
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        List<List<Integer>> util = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelCount = queue.size();
        List<Integer> temp = new ArrayList<>();
        while (!queue.isEmpty()) {
            if (levelCount == 0) {
                levelCount = queue.size();
                util.add(temp);
                temp = new ArrayList<>();
            } else {
                TreeNode tn = queue.remove();
                levelCount--;
                temp.add(tn.val);
                if (tn.left != null)
                    queue.add(tn.left);
                if (tn.right != null)
                    queue.add(tn.right);
            }
        }
        if (temp.size() != 0)
            util.add(temp);
        for (int i=util.size()-1; i>=0; i--) {
            res.add(util.get(i));
        }
        return res;
    }
}
