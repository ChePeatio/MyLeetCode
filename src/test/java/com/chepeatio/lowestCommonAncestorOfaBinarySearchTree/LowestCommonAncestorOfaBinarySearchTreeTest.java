package com.chepeatio.lowestCommonAncestorOfaBinarySearchTree;

import com.chepeatio.lowestCommonAncestorOfaBinarySearchTree.LowestCommonAncestorOfaBinarySearchTree;
import com.chepeatio.utils.TreeNode;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

/**
 * LowestCommonAncestorOfaBinarySearchTree Tester.
 *
 * @author Che Peatio
 * @version 1.0
 * @since <pre>Ê®Ò»ÔÂ 2, 2015</pre>
 */
public class LowestCommonAncestorOfaBinarySearchTreeTest {

    LowestCommonAncestorOfaBinarySearchTree test = new LowestCommonAncestorOfaBinarySearchTree();
    TreeNode root = new TreeNode(6);
    TreeNode p = new TreeNode(7);
    TreeNode q = new TreeNode(8);

    @Before
    public void before() throws Exception {
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
    }

    /**
     * Method: lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
     */
    @Test
    public void testLowestCommonAncestor() throws Exception {
        Assert.assertEquals(root.right, test.lowestCommonAncestor(root, p, q));
    }


} 
