package com.chepeatio.n_Queens;

import com.chepeatio.n_Queens.N_Queens_II;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * N_Queens_II Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ê®Ò»ÔÂ 6, 2015</pre>
 */
@RunWith(Parameterized.class)
public class N_Queens_IITest {

    N_Queens_II test = new N_Queens_II();
    int param;
    int res;

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
