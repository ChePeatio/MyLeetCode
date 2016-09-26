package com.chepeatio.populatingNextRightPointersInEachNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Che Peatio on 2015/11/8.
 */
public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        List<TreeLinkNode> list1 = new ArrayList<>();
        List<TreeLinkNode> list2 = new ArrayList<>();
        list1.add(root);
        List<TreeLinkNode> temp = list1;
        List<TreeLinkNode> other = list2;
        while (true) {
            other.clear();
            int size = temp.size();
            for (int i=0; i<size; i++) {
                temp.get(i).next = i+1 < size ? temp.get(i + 1) : null;
                other.add(temp.get(i).left);
                other.add(temp.get(i).right);
            }
            if (temp.get(size-1).left == null)
                break;
            List<TreeLinkNode> t = temp;
            temp = other;
            other = t;
        }
    }

    public void connectBS(TreeLinkNode root) {

        if (root==null) return;
        if (root.left == null) return;
        link(root.left,root.right);
    }

    public void link(TreeLinkNode left, TreeLinkNode right){

        left.next = right;
        if(left.left==null) return ;
        link(left.left,left.right);
        link(left.right,right.left);
        link(right.left,right.right);
    }
}
