package com.chepeatio.powerOfTwo;

import com.chepeatio.powerOfTwo.PowerOfTwo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * PowerOfTwo Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ê®Ò»ÔÂ 27, 2015</pre>
 */
@RunWith(Parameterized.class)
public class PowerOfTwoTest {

    PowerOfTwo test = new PowerOfTwo();
    int param;
    boolean res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {30, false},
                {32, true},
                {2044, false},
                {8192, true},
                {1, true}
        });
    }

    public PowerOfTwoTest(int parameter, boolean result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: isPowerOfTwo(int n)
     */
    @Test
    public void testIsPowerOfTwo() throws Exception {
        Assert.assertEquals(res, test.isPowerOfTwo(param));
    }
} 
