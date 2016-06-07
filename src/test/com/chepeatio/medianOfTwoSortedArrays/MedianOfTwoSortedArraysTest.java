package test.com.chepeatio.medianOfTwoSortedArrays;

import com.chepeatio.medianOfTwoSortedArrays.MedianOfTwoSortedArrays;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static com.chepeatio.utils.Constant.DELTA;

/**
 * MedianOfTwoSortedArrays Tester.
 *
 * @author Che Peatio
 * @version 1.0
 * @since <pre>Ê®Ò»ÔÂ 11, 2015</pre>
 */
@RunWith(Parameterized.class)
public class MedianOfTwoSortedArraysTest {

    private MedianOfTwoSortedArrays test = new MedianOfTwoSortedArrays();
    private int[] param1;
    private int[] param2;
    private double res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,2,3,4,5,6}, new int[]{3,7,9,10,13}, 5.0},
                {new int[]{1}, new int[]{2}, 1.5}
        });
    }

    public MedianOfTwoSortedArraysTest(int[] parameter1, int[] parameter2, double result) {
        param1 = parameter1;
        param2 = parameter2;
        res = result;
    }
    /**
     * Method: findMedianSortedArrays(int[] nums1, int[] nums2)
     */
    @Test
    public void testFindMedianSortedArrays() throws Exception {
        Assert.assertEquals(res, test.findMedianSortedArrays(param1, param2), DELTA);
    }

    /**
     * Method: findMedianSortedArraysLS(int[] nums1, int[] nums2)
     */
    @Test
    public void testFindMedianSortedArraysLS() throws Exception {
        Assert.assertEquals(res, test.findMedianSortedArraysLS(param1, param2), DELTA);
    }
} 
