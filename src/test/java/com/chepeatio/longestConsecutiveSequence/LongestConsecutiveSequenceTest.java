package com.chepeatio.longestConsecutiveSequence;

import com.chepeatio.longestConsecutiveSequence.LongestConsecutiveSequence;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * LongestConsecutiveSequence Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ê®¶þÔÂ 31, 2015</pre>
 */
@RunWith(Parameterized.class)
public class LongestConsecutiveSequenceTest {

    LongestConsecutiveSequence test = new LongestConsecutiveSequence();
    int[] param;
    int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{100,1,200,2,4,3}, 4},
                {new int[]{1,3,5,7,9}, 1},
                {new int[]{1,2,3,4,5}, 5},
                {new int[]{1,3,2,4,6,5}, 6},
                {new int[]{1,1,1,1,2}, 2}
        });
    }

    public LongestConsecutiveSequenceTest(int[] parameter, int result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: longestConsecutive(int[] nums)
     */
    @Test
    public void testLongestConsecutive() throws Exception {
        Assert.assertEquals(res, test.longestConsecutive(param));
    }
} 
