package com.chepeatio.pathSum;

import com.chepeatio.utils.TreeNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by Che Peatio on 2016/1/4.
 */
public class PathSum {

    /**
     * recursive solution.
     * @param root tree root
     * @param sum target value
     * @return result
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        boolean res = root != null && recursiveHasPathSum(sum, 0, root);
        boolean test = hasPathSumNoRecursive(root, sum);
        return res==test;
    }

    private boolean recursiveHasPathSum(int sum, int count, TreeNode root) {
        count += root.val;
        if (root.left==null && root.right==null) {
            return count == sum;
        } else {
            if (root.left != null) {
                if (recursiveHasPathSum(sum, count, root.left))
                    return true;
            }
            if (root.right != null) {
                if (recursiveHasPathSum(sum, count, root.right))
                    return true;
            }
            return false;
        }
    }
    /**
     * no-recursive solution while using several structures which may cause low efficient.
     * @param root tree root
     * @param sum target value
     * @return determine if the tree path exists.
     */
    public boolean hasPathSumNoRecursive(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> processed = new HashSet<>();
        int count = 0;
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.peek();
            if (processed.contains(temp)) {
                count -= temp.val;
                stack.pop();
            } else {
                count += temp.val;
                if (temp.left==null && temp.right==null) {
                    if (count == sum)
                        return true;
                    else {
                        stack.pop();
                        count -= temp.val;
                    }
                } else {
                    if (temp.left!=null) {
                        stack.add(temp.left);
                    }
                    if (temp.right!=null) {
                        stack.add(temp.right);
                    }
                }
                processed.add(temp);
            }
        }
        return false;
    }

    public TreeNode generateTree() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        return root;
    }
}
