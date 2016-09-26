package com.chepeatio.grayCode;

import com.chepeatio.grayCode.GrayCode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * GrayCode Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ê®Ò»ÔÂ 21, 2015</pre>
 */
@RunWith(Parameterized.class)
public class GrayCodeTest {

    GrayCode test = new GrayCode();
    int param;
    Integer[] res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {2, new Integer[]{0,1,3,2}},
                {3, new Integer[]{0,1,3,2,6,7,5,4}},
                {1, new Integer[]{0, 1}}
        });
    }

    public GrayCodeTest(int parameter, Integer[] result) {
        param = parameter;
        res = result;
    }
    /**
     * Method: grayCode(int n)
     */
    @Test
    public void testGrayCode() throws Exception {
        List<Integer> nums = test.grayCode(param);
        Integer[] temp = nums.toArray(new Integer[nums.size()]);
        Assert.assertArrayEquals(res, temp);
    }
} 
