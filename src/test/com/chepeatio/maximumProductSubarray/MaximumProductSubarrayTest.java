package test.com.chepeatio.maximumProductSubarray;

import com.chepeatio.maximumProductSubarray.MaximumProductSubarray;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * MaximumProductSubarray Tester.
 *
 * @author Che Peatio
 * @version 1.0
 * @since <pre>Ê®ÔÂ 30, 2015</pre>
 */
@RunWith(Parameterized.class)
public class MaximumProductSubarrayTest {

    private MaximumProductSubarray test = new MaximumProductSubarray();
    private int[] param;
    private int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{2,3,-2,4}, 6},
                {new int[]{2,3,4,5}, 120},
                {new int[]{2,-3,4,-5}, 120},
                {new int[]{2,-3,0,5}, 5},
                {new int[]{2,-3,0,5,0,-1,-7}, 7},
                {new int[]{3,5,-7,4,6}, 24},
                {new int[]{0,3,0}, 3},
                {new int[]{-2,0,-1}, 0},
                {new int[]{7,-2,-4}, 56}
        });
    }

    public MaximumProductSubarrayTest(int[] parameter, int result) {
        param = parameter;
        res = result;
    }
    /**
     * Method: maxProduct(int[] nums)
     */
    @Test
    public void testMaxProduct() throws Exception {
        Assert.assertEquals(res, test.maxProduct(param));
    }

    @Test
    public void testMaxProductBS() throws Exception {
        Assert.assertEquals(res, test.maxProductBS(param));
    }
} 
