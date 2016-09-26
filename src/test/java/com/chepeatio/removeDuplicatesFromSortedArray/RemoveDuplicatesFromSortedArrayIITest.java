package com.chepeatio.removeDuplicatesFromSortedArray;

import com.chepeatio.removeDuplicatesFromSortedArray.RemoveDuplicatesFromSortedArrayII;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * RemoveDuplicatesFromSortedArrayII Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ê®¶þÔÂ 26, 2015</pre>
 */
@RunWith(Parameterized.class)
public class RemoveDuplicatesFromSortedArrayIITest {

    RemoveDuplicatesFromSortedArrayII test = new RemoveDuplicatesFromSortedArrayII();
    int[] param;
    int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,1,1,2,2,3}, 5},
                {new int[]{1,1,1,1,1,1,1,1,1,1}, 2},
                {new int[]{1,1,2,2,3,3,4}, 7},
                {new int[]{1}, 1},
                {new int[]{}, 0}
        });
    }

    public RemoveDuplicatesFromSortedArrayIITest(int[] parameter, int result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: removeDuplicates(int[] nums)
     */
    @Test
    public void testRemoveDuplicates() throws Exception {
        Assert.assertEquals(res, test.removeDuplicates(param));
    }


} 
