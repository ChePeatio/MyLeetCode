package test.com.chepeatio.productOfArrayExceptSelf;

import com.chepeatio.productOfArrayExceptSelf.ProductOfArrayExceptSelf;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * ProductOfArrayExceptSelf Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ê®Ò»ÔÂ 1, 2015</pre>
 */
@RunWith(Parameterized.class)
public class ProductOfArrayExceptSelfTest {

    ProductOfArrayExceptSelf test = new ProductOfArrayExceptSelf();
    int[] param;
    int[] res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,2,3,4}, new int[]{24,12,8,6}},
                {new int[]{2, 3, 4, 5}, new int[]{60,40,30,24}},
                {new int[]{2, -3, 4, -5}, new int[]{60,-40,30,-24}},
                {new int[]{2, -3, 0, 5}, new int[]{0,0,-30,0}},
                {new int[]{0, 3, 0}, new int[]{0,0,0}}
        });
    }

    public ProductOfArrayExceptSelfTest(int[] parameter, int[] result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: productExceptSelf(int[] nums)
     */
    @Test
    public void testProductExceptSelf() throws Exception {
        Assert.assertArrayEquals(res, test.productExceptSelf(param));
    }

    /**
     * Method: productExceptSelfAS(int[] nums)
     */
    @Test
    public void testProductExceptSelfAS() throws Exception {
        Assert.assertArrayEquals(res, test.productExceptSelfAS(param));
    }
} 
