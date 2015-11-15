package test.com.chepeatio.maximumSubarray;

import com.chepeatio.maximumSubarray.MaximumSubarray;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * MaximumSubarray Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ê®Ò»ÔÂ 15, 2015</pre>
 */
@RunWith(Parameterized.class)
public class MaximumSubarrayTest {

    MaximumSubarray test = new MaximumSubarray();
    int[] param;
    int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6},
                {new int[]{-6, -1, -3, -4, -9}, -1},
                {new int[]{1,2,3,4,5}, 15},
                {new int[]{0}, 0},
                {new int[]{1,0,-10,7,-11,3,0,5,-2}, 8}
        });
    }

    public MaximumSubarrayTest(int[] parameter, int result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: maxSubArray(int[] nums)
     */
    @Test
    public void testMaxSubArray() throws Exception {
        Assert.assertEquals(res, test.maxSubArray(param));
    }
} 
