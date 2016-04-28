package test.com.chepeatio.threeSumClosest;

import com.chepeatio.threeSumClosest.ThreeSumClosest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * ThreeSumClosest Tester.
 *
 * @author Che Peatio
 * @version 1.0
 * @since <pre>ËÄÔÂ 28, 2016</pre>
 */
@RunWith(Parameterized.class)
public class ThreeSumClosestTest {

    ThreeSumClosest test = new ThreeSumClosest();
    int[] param1;
    int param2;
    int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{-1, 2, 1, -4}, 1, 2},
                {new int[]{0, 0, 0}, 0, 0}
        });
    }

    public ThreeSumClosestTest(int[] parameter1, int parameter2, int result) {
        param1 = parameter1;
        param2 = parameter2;
        res = result;
    }

    /**
     * Method: threeSumClosest(int[] nums, int target)
     */
    @Test
    public void testThreeSumClosest() throws Exception {
        Assert.assertEquals(res, test.threeSumClosest(param1, param2));
    }
} 
