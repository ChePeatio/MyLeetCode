package com.chepeatio.bitwiseANDofNumbersRange;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * BitwiseANDofNumbersRange Tester.
 *
 * @author Che Peatio
 * @version 1.0
 * @since <pre>ʮһ�� 14, 2015</pre>
 */
@RunWith(Parameterized.class)
public class BitwiseANDofNumbersRangeTest {

    BitwiseANDofNumbersRange test = new BitwiseANDofNumbersRange();
    int param1, param2;
    int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {5, 7, 4},
                {2, 10000, 0},
                {0, 2147483647, 0}
        });
    }

    public BitwiseANDofNumbersRangeTest(int parameter1, int parameter2, int result) {
        param1 = parameter1;
        param2 = parameter2;
        res = result;
    }

    /**
     * Method: rangeBitwiseAnd(int m, int n)
     */
    @Test
    public void testRangeBitwiseAnd() throws Exception {
        Assert.assertEquals(res, test.rangeBitwiseAnd(param1, param2));
    }
} 
