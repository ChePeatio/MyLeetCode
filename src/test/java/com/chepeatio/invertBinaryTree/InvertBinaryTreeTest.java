package com.chepeatio.invertBinaryTree;

import com.chepeatio.utils.TreeNode;
import com.chepeatio.invertBinaryTree.InvertBinaryTree;

import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;

/** 
* InvertBinaryTree Tester. 
* 
* @author <Authors name> 
* @since <pre>Ê®ÔÂ 27, 2015</pre> 
* @version 1.0 
*/ 
public class InvertBinaryTreeTest { 

    InvertBinaryTree test = new InvertBinaryTree();
    TreeNode r = new TreeNode(4);

    @Before
    public void before() throws Exception {
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(7);
        r.left = l1;
        r.right = r1;
        l1.left = new TreeNode(1);
        l1.right = new TreeNode(3);
        r1.left = new TreeNode(6);
        r1.right = new TreeNode(9);
    }

    /**
    *
    * Method: invertTree(TreeNode root)
    *
    */
    @Test
    public void testInvertTree() throws Exception {
        ArrayList<Integer> originalOrder = new ArrayList<>();
        ArrayList<Integer> resultOrder = new ArrayList<>();
        preorderTree(r, originalOrder);
        test.invertTree(r);
        preorderTree(r, resultOrder);
        assertArrayEquals(originalOrder.toArray(), reverseArray(resultOrder));
    }

    private void preorderTree(TreeNode tn, ArrayList<Integer> al) {
        if (tn == null)
            return;
        preorderTree(tn.left, al);
        al.add(tn.val);
        preorderTree(tn.right, al);
    }

    private Integer[] reverseArray(ArrayList<Integer> al) {
        Integer[] res = new Integer[al.size()];
        for (int i=0; i<res.length; i++) {
            res[i] = al.get(res.length - 1 - i);
        }
        return res;
    }
}
