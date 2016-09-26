package com.chepeatio.minimumPathSum;

import com.chepeatio.minimumPathSum.MinimumPathSum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * MinimumPathSum Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ê®¶þÔÂ 5, 2015</pre>
 */
@RunWith(Parameterized.class)
public class MinimumPathSumTest {

    MinimumPathSum test = new MinimumPathSum();
    int[][] param;
    int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}}, 18},
                {new int[][]{{0, 0, 5, 7}, {3, 0, 0, 4}, {2, 8, 0, 0}}, 0}
        });
    }

    public MinimumPathSumTest(int[][] parameter, int result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: minPathSum(int[][] grid)
     */
    @Test
    public void testMinPathSum() throws Exception {
        Assert.assertEquals(res, test.minPathSum(param));
    }
} 
