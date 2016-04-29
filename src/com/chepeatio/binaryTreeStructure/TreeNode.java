package com.chepeatio.binaryTreeStructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Che Peatio on 2016/4/29.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) {
        val = x;
    }

    /**
     * Using a serialized list of tree nodes to generate a binary tree.
     * There is detail information: https://leetcode.com/problems/binary-tree-inorder-traversal/
     * @param serializedTreeNode a serialized list of tree nodes
     * @return the node of tree root
     */
    public static TreeNode generateTree(String serializedTreeNode) {
        String[] tokens = serializedTreeNode.split(",");
        if (tokens.length <= 0)
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int pos = 1;
        while (pos < tokens.length) {

            TreeNode temp = queue.remove();
            if (!tokens[pos].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(tokens[pos]));
                temp.left = left;
                queue.add(left);
            }
            pos++;

            if (pos >= tokens.length)
                break;
            if (!tokens[pos].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(tokens[pos]));
                temp.right = right;
                queue.add(right);
            }
            pos++;
        }
        return root;
    }

    /**
     * Print the binary tree.
     * @param root the root of the binary tree.
     */
    public static void printTree(TreeNode root) {
        if (root.right != null) {
            root.right.printTree(true, "");
        }
        root.printNodeValue();
        if (root.left != null) {
            root.left.printTree(false, "");
        }
    }

    private void printNodeValue(){
        System.out.println("" + val);
    }

    private void printTree(boolean isRight, String indent) {
        if (right != null) {
            right.printTree(true, indent + (isRight ? "        " : " |      "));
        }
        System.out.print(indent);
        if (isRight) {
            System.out.print(" /");
        } else {
            System.out.print(" \\");
        }
        System.out.print("----- ");
        printNodeValue();
        if (left != null) {
            left.printTree(false, indent + (isRight ? " |      " : "        "));
        }
    }
}
