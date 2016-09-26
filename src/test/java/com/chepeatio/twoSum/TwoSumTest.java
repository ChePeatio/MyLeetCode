package com.chepeatio.twoSum;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * TwoSum Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ê®Ò»ÔÂ 8, 2015</pre>
 */
@RunWith(Parameterized.class)
public class TwoSumTest {

    private TwoSum test = new TwoSum();
    private int[] param;
    private int tar;
    private int[] res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 3, 4, 5}, 8, new int[]{3, 5}},
                {new int[]{1, 2, 3, 7, 4}, 7, new int[]{3, 5}},
                {new int[]{3, 4}, 7, new int[]{1, 2}},
                {new int[]{0,3,4,0}, 0, new int[]{1,4}},
                {new int[]{0, -3, 3, 9}, 6, new int[]{2,4}}
        });
    }

    public TwoSumTest(int[] parameter, int target, int[] result) {
        param = parameter;
        tar = target;
        res = result;
    }

    /**
     * Method: twoSum(int[] nums, int target)
     */
    @Test
    public void testTwoSum() throws Exception {
        Assert.assertArrayEquals(res, test.twoSum(param, tar));
    }

    /**
     * Method: twoSumBS(int[] nums, int target)
     */
    @Ignore
    @Test
    public void testTwoSumBS() throws Exception {
        Assert.assertArrayEquals(res, test.twoSumBS(param, tar));
    }
} 
