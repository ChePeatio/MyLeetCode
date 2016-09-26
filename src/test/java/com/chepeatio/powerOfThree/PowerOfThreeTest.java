package com.chepeatio.powerOfThree;

import com.chepeatio.powerOfThree.PowerOfThree;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * PowerOfThree Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ò»ÔÂ 10, 2016</pre>
 */
@RunWith(Parameterized.class)
public class PowerOfThreeTest {

    PowerOfThree test = new PowerOfThree();
    int param;
    boolean res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {1, true},
                {3, true},
                {768, false},
                {9, true},
                {18, false}
        });
    }

    public PowerOfThreeTest(int parameter, boolean result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: isPowerOfThree(int n)
     */
    @Test
    public void testIsPowerOfThree() throws Exception {
        Assert.assertEquals(res, test.isPowerOfThree(param));
    }
} 
