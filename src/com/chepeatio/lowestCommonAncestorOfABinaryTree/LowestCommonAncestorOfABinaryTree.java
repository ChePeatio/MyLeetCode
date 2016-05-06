package com.chepeatio.lowestCommonAncestorOfABinaryTree;

import com.chepeatio.utils.TreeNode;

import java.util.*;

/**
 * Created by Che Peatio on 2016/5/4.
 */
public class LowestCommonAncestorOfABinaryTree {

    /**
     * �ǳ��̵Ĵ��룬���Լ�֮ǰ�뵽��˼·���ƣ������Լ�û�뵽���һ����ô��������
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
     * ���ȱ�����������ֱ����p��q������parent�У����p�����ȼ��뵽ancestor�У�
     * ����q�������Ƿ���ancestor�У��Ӷ��ҵ���С���ȡ�
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
