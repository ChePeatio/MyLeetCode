package com.chepeatio.populatingNextRightPointersInEachNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Che Peatio on 2015/12/20.
 */
public class PopulatingNextRightPointersInEachNodeII {

    /**
     * This is the solution without extra space and effectiveness is not bad.
     * @param root root of the tree
     */
    public void connect(TreeLinkNode root) {
        TreeLinkNode levelHead = root, nextLevelHead = null;
        while (levelHead != null) {
            TreeLinkNode tln = levelHead, tail = null;
            while (tln != null) {
                if (tln.left!=null && tln.right!=null)
                    tln.left.next = tln.right;
                TreeLinkNode sub;
                if (tln.left != null) {
                    sub = tln.left;
                } else if (tln.right != null) {
                    sub = tln.right;
                } else {
                    sub = null;
                }
                if (sub != null) {
                    if (nextLevelHead == null) {
                        nextLevelHead = sub;
                        tail = sub;
                    } else {
                        tail.next = sub;
                    }
                    while (tail.next != null) {
                        tail = tail.next;
                    }
                }
                tln = tln.next;
            }
            levelHead = nextLevelHead;
            nextLevelHead = null;
        }
    }

    /**
     * This is the solution using queue while the request requires no extra space.
     * @param root root of the tree
     */
    public void connectLS(TreeLinkNode root) {
        if (root != null) {
            Queue<TreeLinkNode> queue = new LinkedList<>();
            queue.add(root);
            int cur = 1;
            while (!queue.isEmpty()) {
                if (cur == 1){
                    TreeLinkNode tln = queue.remove();
                    if (tln.left != null)
                        queue.add(tln.left);
                    if (tln.right != null)
                        queue.add(tln.right);
                    tln.next = null;
                    cur = queue.size();
                } else {
                    TreeLinkNode tln = queue.remove();
                    if (tln.left != null)
                        queue.add(tln.left);
                    if (tln.right != null)
                        queue.add(tln.right);
                    tln.next = queue.peek();
                    cur--;
                }
            }
        }
    }
}
