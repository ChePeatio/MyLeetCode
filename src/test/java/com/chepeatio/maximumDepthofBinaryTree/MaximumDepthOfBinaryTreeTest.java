package com.chepeatio.maximumDepthOfBinaryTree;

<<<<<<< HEAD:src/test/java/com/chepeatio/maximumDepthofBinaryTree/MaximumDepthOfBinaryTreeTest.java
=======
import com.chepeatio.maximumDepthOfBinaryTree.MaximumDepthOfBinaryTree;
import com.chepeatio.utils.TreeNode;

import org.junit.Assert;
>>>>>>> 6f748a96e94b25ce3b68f7508552f9ff61b23e74:src/test/com/chepeatio/maximumDepthofBinaryTree/MaximumDepthOfBinaryTreeTest.java
import org.junit.Test;
import org.junit.Before;


/** 
* MaximumDepthOfBinaryTree Tester. 
* 
* @author Che Peatio
* @since <pre>Ê®ÔÂ 27, 2015</pre> 
* @version 1.0 
*/ 
public class MaximumDepthOfBinaryTreeTest { 
    MaximumDepthOfBinaryTree test = new MaximumDepthOfBinaryTree();
    TreeNode root = new TreeNode(7);

    @Before
    public void before() throws Exception {
        TreeNode r_l1 = new TreeNode(5);
        root.left = r_l1;
        TreeNode l1_l2 = new TreeNode(3);
        r_l1.left = l1_l2;
        root.right = new TreeNode(6);
        l1_l2.right = new TreeNode(4);
    }

    /**
    *
    * Method: maxDepth(TreeNode root)
    *
    */
    @Test
    public void testMaxDepth() throws Exception {
        Assert.assertEquals(4, test.maxDepth(root));
    }
}