package com.chepeatio.reverseInteger;

import com.chepeatio.reverseInteger.ReverseInteger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * ReverseInteger Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ò»ÔÂ 16, 2016</pre>
 */
@RunWith(Parameterized.class)
public class ReverseIntegerTest {

    ReverseInteger test = new ReverseInteger();
    int param;
    int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {-2147483648, 0},
                {1234567899, 0},
                {768, 867},
                {-9, -9},
                {0, 0}
        });
    }

    public ReverseIntegerTest(int parameter, int result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: reverse(int x)
     */
    @Test
    public void testReverse() throws Exception {
        Assert.assertEquals(res, test.reverse(param));
    }
} 
