package com.chepeatio.perfectSquares;

import com.chepeatio.perfectSquares.PerfectSquares;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * PerfectSquares Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ò»ÔÂ 5, 2016</pre>
 */
@RunWith(Parameterized.class)
public class PerfectSquaresTest {

    PerfectSquares test = new PerfectSquares();
    int param;
    int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {1, 1},
                {18, 2},
                {19, 3},
                {79, 4},
                {75, 3}
        });
    }

    public PerfectSquaresTest(int parameter, int result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: numSquares(int n)
     */
    @Test
    public void testNumSquares() throws Exception {
        Assert.assertEquals(res, test.numSquares(param));
    }
} 
