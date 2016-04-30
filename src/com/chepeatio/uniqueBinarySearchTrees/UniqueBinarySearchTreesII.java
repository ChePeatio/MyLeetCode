package com.chepeatio.uniqueBinarySearchTrees;

import com.chepeatio.binaryTreeStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Che Peatio on 2016/4/30.
 */
public class UniqueBinarySearchTreesII {

    /**
     * ��ͬ����һ����Ŀ������Ŀ��Ҫ��¼���е���Ϣ������ֻ���õݹ�ķ�������
     * @param n ���ڵ��ֵ
     * @return ���б�
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
