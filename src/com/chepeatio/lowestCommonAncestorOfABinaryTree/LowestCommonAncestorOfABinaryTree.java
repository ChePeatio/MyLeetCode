package com.chepeatio.lowestCommonAncestorOfABinaryTree;

import com.chepeatio.utils.TreeNode;

import java.util.*;

/**
 * Created by Che Peatio on 2016/5/4.
 */
public class LowestCommonAncestorOfABinaryTree {

    /**
     * 非常短的代码，和自己之前想到的思路类似，但是自己没想到最后一行这么精妙的语句
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestorShortest(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }

    /**
     * 首先遍历整个树，直到将p和q囊括到parent中，随后将p的祖先加入到ancestor中，
     * 在找q的祖先是否在ancestor中，从而找到最小祖先。
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        parent.put(root, null);
        stack.push(root);

        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        while (!ancestors.contains(q))
            q = parent.get(q);
        return q;
    }
}
