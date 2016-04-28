package test.com.chepeatio.threeSum;

import com.chepeatio.threeSum.ThreeSum;
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
 * ThreeSum Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ËÄÔÂ 28, 2016</pre>
 */
@RunWith(Parameterized.class)
public class ThreeSumTest {

    ThreeSum test = new ThreeSum();
    int[] param;
    int[] res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{-1, 0, 1, 2, -1, 4}, new int[]{-1, -1, 2}},
                {new int[]{0, 0, 0}, new int[]{0, 0, 0}}
        });
    }

    public ThreeSumTest(int[] paramemter, int[] result) {
        param = paramemter;
        res = result;
    }

    /**
     * Method: threeSum(int[] nums)
     */
    @Test
    public void testThreeSum() throws Exception {
        List<List<Integer>> lists = test.threeSum(param);
        for (int i=0; i<3; i++) {
            Assert.assertEquals(res[i], (int)lists.get(0).get(i));
        }
    }
} 
