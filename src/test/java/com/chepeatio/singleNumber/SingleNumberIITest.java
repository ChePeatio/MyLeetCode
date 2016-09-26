package com.chepeatio.singleNumber;

import com.chepeatio.singleNumber.SingleNumberII;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * SingleNumberII Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ê®Ò»ÔÂ 12, 2015</pre>
 */
@RunWith(Parameterized.class)
public class SingleNumberIITest {

    SingleNumberII test = new SingleNumberII();
    int[] param;
    int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 1, 3, 4, 1, 3, 3}, 4},
                {new int[]{4}, 4}
        });
    }

    public SingleNumberIITest(int[] parameter, int result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: singleNumber(int[] nums)
     */
    @Test
    public void testSingleNumber() throws Exception {
        Assert.assertEquals(res, test.singleNumber(param));
    }

    /**
     * Method: singleNumberBS(int[] nums)
     */
    @Test
    public void testSingleNumberBS() throws Exception {
        Assert.assertEquals(res, test.singleNumberBS(param));
    }
} 
