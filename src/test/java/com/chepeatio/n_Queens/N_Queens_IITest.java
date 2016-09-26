package com.chepeatio.n_Queens;

import com.chepeatio.n_Queens.N_Queens_II;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * N_Queens_II Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ʮһ�� 6, 2015</pre>
 */
@RunWith(Parameterized.class)
public class N_Queens_IITest {

    private N_Queens_II test = new N_Queens_II();
    private int param;
    private int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {1, 1},
                {8, 92},
                {2, 0}
        });
    }

    public N_Queens_IITest(int parameter, int result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: totalNQueens(int n)
     */
    @Test
    public void testTotalNQueens() throws Exception {
        Assert.assertEquals(res, test.totalNQueens(param));
    }
} 
