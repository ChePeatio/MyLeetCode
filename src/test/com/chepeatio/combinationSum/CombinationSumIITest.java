package test.com.chepeatio.combinationSum;

import com.chepeatio.combinationSum.CombinationSumII;
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
 * CombinationSumII Tester.
 *
 * @author Che Peatio
 * @version 1.0
 * @since <pre>ÎåÔÂ 21, 2016</pre>
 */
@RunWith(Parameterized.class)
public class CombinationSumIITest {

    CombinationSumII test = new CombinationSumII();
    int[] param1;
    int param2;
    int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{10,1,2,7,6,1,5}, 8, 4}
        });
    }

    public CombinationSumIITest(int[] parameter1, int parameter2, int result) {
        param1 = parameter1;
        param2 = parameter2;
        res = result;
    }

    /**
     * Method: combinationSum2(int[] candidates, int target)
     */
    @Test
    public void testCombinationSum2() throws Exception {
        Assert.assertEquals(res, test.combinationSum2(param1, param2).size());
    }
} 
