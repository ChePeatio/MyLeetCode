package com.chepeatio.uniqueBinarySearchTrees;

import com.chepeatio.uniqueBinarySearchTrees.UniqueBinarySearchTrees;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * UniqueBinarySearchTrees Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ê®Ò»ÔÂ 9, 2015</pre>
 */
@RunWith(Parameterized.class)
public class UniqueBinarySearchTreesTest {

    UniqueBinarySearchTrees test = new UniqueBinarySearchTrees();
    int param;
    int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {3, 5},
                {4, 14},
                {1, 1},
                {2, 2}
        });
    }

    public UniqueBinarySearchTreesTest(int parameter, int result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: numTrees(int n)
     */
    @Test
    public void testNumTrees() throws Exception {
        Assert.assertEquals(res, test.numTrees(param));
    }

    /**
     * Method: numTreesTLE(int n)
     */
    /*@Test
    public void testNumTreesTLE() throws Exception {
        Assert.assertEquals(res, test.numTreesTLE(param));
    }*/
}
