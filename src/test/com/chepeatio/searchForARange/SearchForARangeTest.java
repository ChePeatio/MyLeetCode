package test.com.chepeatio.searchForARange;

import com.chepeatio.searchForARange.SearchForARange;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * SearchForARange Tester.
 *
 * @author Che Peatio
 * @version 1.0
 * @since <pre>ÎåÔÂ 8, 2016</pre>
 */
@RunWith(Parameterized.class)
public class SearchForARangeTest {

    SearchForARange test = new SearchForARange();
    int[] param1;
    int param2;
    int[] res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{5, 7, 7, 8, 8, 10}, 8, new int[]{3, 4}},
                {new int[]{1,1,1,1,1,1}, 3, new int[]{-1, -1}},
                {new int[]{1,2,2,3,4,5,6}, 6, new int[]{6, 6}},
                {new int[]{2,2,2,2,2,2,2}, 2, new int[]{0, 6}},
                {new int[]{1,2,3,4,5,6}, 0, new int[]{-1, -1}}
        });
    }

    public SearchForARangeTest(int[] parameter1, int parameter2, int[] result) {
        param1 = parameter1;
        param2 = parameter2;
        res = result;
    }

    /**
     * Method: searchRange(int[] nums, int target)
     */
    @Test
    public void testSearchRange() throws Exception {
        Assert.assertArrayEquals(res, test.searchRange(param1, param2));
    }
} 
