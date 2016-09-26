package com.chepeatio.houseRobber;

import com.chepeatio.houseRobber.HouseRobberII;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * HouseRobberII Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ò»ÔÂ 21, 2016</pre>
 */
@RunWith(Parameterized.class)
public class HouseRobberIITest {

    HouseRobberII test = new HouseRobberII();
    int[] param;
    int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{5, 7, 1, 4, 0, 0, 0, 7, 3}, 18},
                {new int[]{17, 9, 13, 1, 19}, 32},
                {new int[]{1, 1, 1}, 1},
                {new int[]{1, 99, 100, 3, 33}, 133},
                {new int[]{1, 99, 100, 19, 35, 22}, 140}
        });
    }

    public HouseRobberIITest(int[] parameter, int result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: rob(int[] nums)
     */
    @Test
    public void testRob() throws Exception {
        Assert.assertEquals(res, test.robOriginalSolution(param));
    }
} 
