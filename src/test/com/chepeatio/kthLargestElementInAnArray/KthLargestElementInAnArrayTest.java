package test.com.chepeatio.kthLargestElementInAnArray;

import com.chepeatio.kthLargestElementInAnArray.KthLargestElementInAnArray;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * KthLargestElementInAnArray Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ò»ÔÂ 7, 2016</pre>
 */
@RunWith(Parameterized.class)
public class KthLargestElementInAnArrayTest {

    KthLargestElementInAnArray test = new KthLargestElementInAnArray();
    int[] param1;
    int param2;
    int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{3, 2, 1, 5, 6, 4}, 2, 5},
                {new int[]{1, 1, 1, 1, 1, 1}, 2, 1},
                {new int[]{1, 1, 2, 2, 3, 3, 4}, 4, 2},
                {new int[]{11, 22, 77, 33, 44}, 1, 77}
        });
    }

    public KthLargestElementInAnArrayTest(int[] parameter1, int parameter2, int result) {
        param1 = parameter1;
        param2 = parameter2;
        res = result;
    }

    /**
     * Method: findKthLargest(int[] nums, int k)
     */
    @Test
    public void testFindKthLargest() throws Exception {
        Assert.assertEquals(res, test.findKthLargest(param1, param2));
    }
} 
