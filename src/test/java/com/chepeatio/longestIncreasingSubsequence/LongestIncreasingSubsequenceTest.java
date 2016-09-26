package com.chepeatio.longestIncreasingSubsequence;

import com.chepeatio.longestIncreasingSubsequence.LongestIncreasingSubsequence;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * LongestIncreasingSubsequence Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ê®¶þÔÂ 23, 2015</pre>
 */
@RunWith(Parameterized.class)
public class LongestIncreasingSubsequenceTest {

    LongestIncreasingSubsequence test = new LongestIncreasingSubsequence();
    int[] param;
    int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{10,9,2,5,3,7,101,18}, 4},
                {new int[]{1,2,3,4}, 4},
                {new int[]{4,3,2,1}, 1},
                {new int[]{2,3,1,4}, 3},
                {new int[]{8,9,1,2,3}, 3}
        });
    }

    public LongestIncreasingSubsequenceTest(int[] parameter, int result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: lengthOfLIS(int[] nums)
     */
    @Test
    public void testLengthOfLIS() throws Exception {
        Assert.assertEquals(res, test.lengthOfLIS(param));
    }
} 
