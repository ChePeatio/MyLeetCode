package com.chepeatio.medianOfTwoSortedArrays;

import com.chepeatio.medianOfTwoSortedArrays.MedianOfTwoSortedArrays;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * MedianOfTwoSortedArrays Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ê®Ò»ÔÂ 11, 2015</pre>
 */
@RunWith(Parameterized.class)
public class MedianOfTwoSortedArraysTest {

    MedianOfTwoSortedArrays test = new MedianOfTwoSortedArrays();
    int[] param1;
    int[] param2;
    double res;

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
        Assert.assertEquals(res, test.findMedianSortedArrays(param1, param2));
    }

    /**
     * Method: findMedianSortedArraysLS(int[] nums1, int[] nums2)
     */
    @Test
    public void testFindMedianSortedArraysLS() throws Exception {
        Assert.assertEquals(res, test.findMedianSortedArraysLS(param1, param2));
    }
} 
