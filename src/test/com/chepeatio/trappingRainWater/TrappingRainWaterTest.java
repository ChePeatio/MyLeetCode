package test.com.chepeatio.trappingRainWater;

import com.chepeatio.trappingRainWater.TrappingRainWater;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * TrappingRainWater Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ê®¶þÔÂ 30, 2015</pre>
 */
@RunWith(Parameterized.class)
public class TrappingRainWaterTest {

    TrappingRainWater test = new TrappingRainWater();
    int[] param;
    int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{0,1,0,2,1,0,1,3,2,1,2,1}, 6},
                {new int[]{1,1,1,1,1,1,100,1}, 0},
                {new int[]{100, 0, 1, 1000}, 199},
                {new int[]{0,1,0}, 0},
                {new int[]{1,0,1,0,1}, 2}
        });
    }

    public TrappingRainWaterTest(int[] parameter, int result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: trap(int[] height)
     */
    @Test
    public void testTrap() throws Exception {
        Assert.assertEquals(res, test.trap(param));
    }
} 
