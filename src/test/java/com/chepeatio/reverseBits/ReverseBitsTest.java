package com.chepeatio.reverseBits;

import com.chepeatio.reverseBits.ReverseBits;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * ReverseBits Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ò»ÔÂ 16, 2016</pre>
 */
@RunWith(Parameterized.class)
public class ReverseBitsTest {

    ReverseBits test = new ReverseBits();
    int param;
    int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {43261596, 964176192},
                {-1, -1},
                {0, 0},
                {1, -2147483648}
        });
    }

    public ReverseBitsTest(int parameter, int result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: reverseBits(int n)
     */
    @Test
    public void testReverseBits() throws Exception {
        Assert.assertEquals(res, test.reverseBits(param));
    }
} 
