package com.chepeatio.uniqueBinarySearchTrees;

import com.chepeatio.binaryTreeStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Che Peatio on 2016/4/30.
 */
public class UniqueBinarySearchTreesII {

    /**
     * 不同于另一个题目，该题目需要记录树中的信息，所以只能用递归的方法建立
     * @param n 树节点的值
     * @return 树列表
     */
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int begin, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (begin > end)
            return res;

        for (int i=begin; i<=end; i++) {
            List<TreeNode> left = generateTrees(begin, i-1);
            List<TreeNode> right = generateTrees(i+1, end);
            if (left.size() == 0) {
                if (right.size() == 0) {
                    res.add(new TreeNode(i));
                } else {
                    for (TreeNode tn : right) {
                        TreeNode root = new TreeNode(i);
                        root.right = tn;
                        res.add(root);
                    }
                }
            } else {
                if (right.size() == 0) {
                    for (TreeNode tn : left) {
                        TreeNode root = new TreeNode(i);
                        root.left = tn;
                        res.add(root);
                    }
                } else {
                    for (TreeNode ltn : left) {
                        for (TreeNode rtn : right) {
                            TreeNode root = new TreeNode(i);
                            root.left = ltn;
                            root.right = rtn;
                            res.add(root);
                        }
                    }
                }
            }
        }
        return res;
    }
}
