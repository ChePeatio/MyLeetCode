package test.com.chepeatio.binaryTreeMaximumPathSum;

import com.chepeatio.binaryTreeMaximumPathSum.BinaryTreeMaximumPathSum;
import com.chepeatio.binaryTreeStructure.TreeNode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * BinaryTreeMaximumPathSum Tester.
 *
 * @author Che Peatio
 * @version 1.0
 * @since <pre>ËÄÔÂ 29, 2016</pre>
 */
@RunWith(Parameterized.class)
public class BinaryTreeMaximumPathSumTest {

    BinaryTreeMaximumPathSum test = new BinaryTreeMaximumPathSum();
    String param;
    int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {"1,-2,-3,1,3,-2,#,-1", 3},
                {"-3", -3},
                {"1,2,3", 6}
        });
    }

    public BinaryTreeMaximumPathSumTest(String parameter, int result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: maxPathSum(TreeNode root)
     */
    @Test
    public void testMaxPathSum() throws Exception {
        TreeNode root = TreeNode.generateTree(param);
        Assert.assertEquals(res, test.maxPathSum(root));
    }
} 
