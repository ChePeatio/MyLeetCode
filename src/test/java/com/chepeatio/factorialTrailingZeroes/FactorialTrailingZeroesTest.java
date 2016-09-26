package com.chepeatio.factorialTrailingZeroes;

import com.chepeatio.factorialTrailingZeroes.FactorialTrailingZeroes;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * FactorialTrailingZeroes Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ê®¶þÔÂ 31, 2015</pre>
 */
@RunWith(Parameterized.class)
public class FactorialTrailingZeroesTest {

    FactorialTrailingZeroes test = new FactorialTrailingZeroes();
    int param;
    int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {4, 0},
                {6, 1},
                {30, 7},
                {100, 24}
        });
    }

    public FactorialTrailingZeroesTest(int parameter, int result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: trailingZeroes(int n)
     */
    @Test
    public void testTrailingZeroes() throws Exception {
        Assert.assertEquals(res, test.trailingZeroes(param));
    }
} 
