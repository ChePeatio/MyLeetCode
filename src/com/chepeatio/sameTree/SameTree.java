package com.chepeatio.sameTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Che Peatio on 2015/10/23.
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p==null && q==null)
            return true;

        if (p==null&&q!=null || p!=null&&q==null)
            return false;

        Queue<TreeNode> queueP = new LinkedList<>();
        Queue<TreeNode> queueQ = new LinkedList<>();

        TreeNode tempP;
        TreeNode tempQ;

        if (p.val != q.val)
            return false;
        queueP.add(p);
        queueQ.add(q);

        while (!queueP.isEmpty()) {
            tempP = queueP.poll();
            tempQ = queueQ.poll();
            if (tempP.left != null) {
                if (tempQ.left != null) {
                    if (tempP.left.val == tempQ.left.val) {
                        queueP.add(tempP.left);
                        queueQ.add(tempQ.left);
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (tempQ.left != null) {
                    return false;
                } else {
                    // do nothing
                }
            }

            if (tempP.right != null) {
                if (tempQ.right != null) {
                    if (tempP.right.val == tempQ.right.val) {
                        queueP.add(tempP.right);
                        queueQ.add(tempQ.right);
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (tempQ.right != null) {
                    return false;
                } else {
                    // do nothing
                }
            }
        }
        return true;
    }

    public boolean isSameTreeBS(TreeNode p, TreeNode q) {
        if (p==null && q==null)
            return true;

        if (p==null || q==null)
            return false;

        return (p.val==q.val) && isSameTreeBS(p.left, q.left) && isSameTreeBS(p.right, q.right);
    }
}
