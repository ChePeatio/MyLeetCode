package test.com.chepeatio.maximumDepthofBinaryTree; 

import com.chepeatio.maximumDepthOfBinaryTree.MaximumDepthOfBinaryTree;
import com.chepeatio.binaryTreeStructure.TreeNode;

import org.junit.Test;
import org.junit.Before;

import static junit.framework.Assert.assertEquals;

/** 
* MaximumDepthOfBinaryTree Tester. 
* 
* @author <Authors name> 
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
        assertEquals(4, test.maxDepth(root));
    }
}