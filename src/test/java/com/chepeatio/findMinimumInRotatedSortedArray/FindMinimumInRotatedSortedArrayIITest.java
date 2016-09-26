package com.chepeatio.findMinimumInRotatedSortedArray;

import com.chepeatio.findMinimumInRotatedSortedArray.FindMinimumInRotatedSortedArrayII;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * FindMinimumInRotatedSortedArrayII Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ê®¶þÔÂ 6, 2015</pre>
 */
@RunWith(Parameterized.class)
public class FindMinimumInRotatedSortedArrayIITest {

    FindMinimumInRotatedSortedArrayII test = new FindMinimumInRotatedSortedArrayII();
    int[] param;
    int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{5,6,7,8,2,2,2,2}, 2},
                {new int[]{7,7,7,7,7,7}, 7},
                {new int[]{3,3,3,4,5}, 3},
                {new int[]{5,6,7,8,0,1,2,3,4}, 0},
                {new int[]{10, 1, 10, 10, 10}, 1},
                {new int[]{1,1,3,1}, 1}
        });
    }

    public FindMinimumInRotatedSortedArrayIITest(int[] parameter, int result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: findMin(int[] nums)
     */
    @Test
    public void testFindMin() throws Exception {
        Assert.assertEquals(res, test.findMin(param));
    }
} 
