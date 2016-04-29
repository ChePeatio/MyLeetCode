package com.chepeatio.flattenBinaryTreeToLinkedList;

import com.chepeatio.binaryTreeStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Che Peatio on 2016/1/10.
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        recursiveTravel(root, list);
        int len = list.size();
        for (int i=0; i<len-1; i++) {
            list.get(i).left = null;
            list.get(i).right = list.get(i+1);
        }
    }

    private void recursiveTravel(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            recursiveTravel(root.left, list);
            recursiveTravel(root.right, list);
        }
    }
}
