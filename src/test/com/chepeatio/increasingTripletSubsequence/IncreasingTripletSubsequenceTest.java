package test.com.chepeatio.increasingTripletSubsequence;

import com.chepeatio.increasingTripletSubsequence.IncreasingTripletSubsequence;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * IncreasingTripletSubsequence Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>¶þÔÂ 21, 2016</pre>
 */
@RunWith(Parameterized.class)
public class IncreasingTripletSubsequenceTest {

    IncreasingTripletSubsequence test = new IncreasingTripletSubsequence();
    int[] param;
    boolean res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,2,3,4,5}, true},
                {new int[]{5,4,3,2,1}, false},
                {new int[]{5,4,3,1,2,3}, true},
                {new int[]{1,1,1,1,1}, false},
                {new int[]{1,2}, false}
        });
    }

    public IncreasingTripletSubsequenceTest(int[] parameter, boolean result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: increasingTriplet(int[] nums)
     */
    @Test
    public void testIncreasingTriplet() throws Exception {
        Assert.assertEquals(res, test.increasingTriplet(param));
    }
} 
