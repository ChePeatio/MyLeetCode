package com.chepeatio.symmetricTree;

/**
 * Created by Che Peatio on 2015/12/14.
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

    public void testFunction1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        if (isSymmetric(root))
            System.out.println("Good");
        else
            System.out.println("Wrong");
    }

    public void testFunction2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        //root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        //root.right.right = new TreeNode(3);
        if (isSymmetric(root))
            System.out.println("Wrong");
        else
            System.out.println("Good");
    }
}
