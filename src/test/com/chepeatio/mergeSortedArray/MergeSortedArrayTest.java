package test.com.chepeatio.mergeSortedArray;

import com.chepeatio.mergeSortedArray.MergeSortedArray;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * MergeSortedArray Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ò»ÔÂ 13, 2016</pre>
 */
@RunWith(Parameterized.class)
public class MergeSortedArrayTest {

    MergeSortedArray test = new MergeSortedArray();
    int[] param1;
    int param2;
    int[] param3;
    int param4;
    int[] res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,2,3,0,0,0}, 3, new int[]{4,5,6}, 3, new int[]{1,2,3,4,5,6}},
                {new int[]{1,3,5,0,0}, 3, new int[]{2,4}, 2, new int[]{1,2,3,4,5}},
                {new int[]{0,0}, 0, new int[]{100, 1000}, 2, new int[]{100, 1000}}
        });
    }

    public MergeSortedArrayTest(int[] parameter1, int parameter2, int[] parameter3, int parameter4, int[] result) {
        param1 = parameter1;
        param2 = parameter2;
        param3 = parameter3;
        param4 = parameter4;
        res = result;
    }
    /**
     * Method: merge(int[] nums1, int m, int[] nums2, int n)
     */
    @Test
    public void testMerge() throws Exception {
        test.merge(param1,param2,param3,param4);
        Assert.assertArrayEquals(res, param1);
    }
} 
