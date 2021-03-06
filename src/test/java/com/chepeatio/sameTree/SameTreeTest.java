package com.chepeatio.sameTree;

import com.chepeatio.utils.TreeNode;
import com.chepeatio.sameTree.SameTree;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

/** 
* SameTree Tester. 
* 
* @author Che Peatio
* @since <pre>ʮ�� 27, 2015</pre> 
* @version 1.0 
*/ 
public class SameTreeTest { 

    private SameTree test = new SameTree();
    private TreeNode p = new TreeNode(3);
    private TreeNode q = new TreeNode(3);
    @Before
    public void before() throws Exception {
        p.left = new TreeNode(7);
        p.left.left = new TreeNode(8);
        p.right = new TreeNode(6);
        p.right.left = new TreeNode(9);
        p.right.right = new TreeNode(2);
        p.right.left.right = new TreeNode(1);
        p.right.right.left = new TreeNode(5);

        q.left = new TreeNode(7);
        q.left.left = new TreeNode(8);
        q.right = new TreeNode(6);
        q.right.left = new TreeNode(9);
        q.right.right = new TreeNode(2);
        q.right.left.right = new TreeNode(1);
        q.right.right.left = new TreeNode(5);
    }

    /**
    *
    * Method: isSameTree(TreeNode p, TreeNode q)
    *
    */
    @Test
    public void testIsSameTree() throws Exception {
        Assert.assertTrue(test.isSameTree(p, q));
    }

    /**
    *
    * Method: isSameTreeBS(TreeNode p, TreeNode q)
    *
    */
    @Test
    public void testIsSameTreeBS() throws Exception {
        Assert.assertTrue(test.isSameTreeBS(p, q));
    }
} 
