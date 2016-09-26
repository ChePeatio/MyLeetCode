package com.chepeatio.burstBalloons;

import com.chepeatio.burstBalloons.BurstBalloons;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * BurstBalloons Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ò»ÔÂ 2, 2016</pre>
 */
@RunWith(Parameterized.class)
public class BurstBalloonsTest {

    BurstBalloons test = new BurstBalloons();
    int[] param;
    int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,0,1}, 2},
                {new int[]{3,1,5,8}, 167},
                {new int[]{1,1,1,1,1,1,1,1,1}, 9},
                {new int[]{1,2,3,4,5,6}, 252}
        });
    }

    public BurstBalloonsTest(int[] parameter, int result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: maxCoins(int[] nums)
     */
    @Test
    public void testMaxCoins() throws Exception {
        Assert.assertEquals(res, test.maxCoins(param));
    }
} 
