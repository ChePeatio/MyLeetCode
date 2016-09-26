package com.chepeatio.superUglyNumber;

import com.chepeatio.superUglyNumber.SuperUglyNumber;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * SuperUglyNumber Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ò»ÔÂ 11, 2016</pre>
 */
@RunWith(Parameterized.class)
public class SuperUglyNumberTest {

    SuperUglyNumber test = new SuperUglyNumber();
    int param;
    int[] params;
    int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {12, new int[]{2,7,13,19}, 32},
                {2, new int[]{7,19,23}, 7}
        });
    }

    public SuperUglyNumberTest(int parameter, int[] parameters, int result) {
        param = parameter;
        params = parameters;
        res = result;
    }

    /**
     * Method: nthSuperUglyNumber(int n, int[] primes)
     */
    @Test
    public void testNthSuperUglyNumber() throws Exception {
        Assert.assertEquals(res, test.nthSuperUglyNumber(param,params));
    }
} 
