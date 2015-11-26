package test.com.chepeatio.kthSmallestElementInaBST;

import com.chepeatio.kthSmallestElementInaBST.KthSmallestElementInaBST;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * KthSmallestElementInaBST Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ê®Ò»ÔÂ 26, 2015</pre>
 */
@RunWith(Parameterized.class)
public class KthSmallestElementInaBSTTest {

    KthSmallestElementInaBST test = new KthSmallestElementInaBST();
    int param;
    int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {5, 5},
                {1, 1},
                {3, 3},
                {7, 7},
                {8, 8}
        });
    }

    public KthSmallestElementInaBSTTest(int parameter, int result) {
        param = parameter;
        res = result;
    }
    /**
     * Method: kthSmallest(TreeNode root, int k)
     */
    @Test
    public void testKthSmallest() throws Exception {
        Assert.assertEquals(res, test.kthSmallest(test.generateTree(), param));
    }
}
