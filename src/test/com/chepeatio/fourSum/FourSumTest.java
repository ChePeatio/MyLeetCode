package test.com.chepeatio.fourSum;

import com.chepeatio.fourSum.FourSum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * FourSum Tester.
 *
 * @author Che Peatio
 * @version 1.0
 * @since <pre>ËÄÔÂ 30, 2016</pre>
 */
@RunWith(Parameterized.class)
public class FourSumTest {

    FourSum test = new FourSum();
    int[] param1;
    int param2;
    int[][] res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 0, -1, 0, -2, 2}, 0, new int[][]{new int[]{-2, -1, 1, 2}, new int[]{-2, 0, 0, 2}, new int[]{-1, 0, 0, 1}}},
                {new int[]{0, 4, -5, 2, -2, 4, 2, -1, 4}, 12, new int[][]{new int[]{0, 4, 4, 4}, new int[]{2, 2, 4, 4}}}
        });
    }

    public FourSumTest(int[] parameter1, int parameter2, int[][] result) {
        param1 = parameter1;
        param2 = parameter2;
        res = result;
    }

    /**
     * Method: fourSum(int[] nums, int target)
     */
    @Test
    public void testFourSum() throws Exception {
        List<List<Integer>> testResult = test.fourSum(param1,param2);
        for (int i=0; i<res.length; i++) {
            for (int j=0; j<4; j++) {
                Assert.assertEquals(res[i][j], (int)testResult.get(i).get(j));
            }
        }
    }
} 
