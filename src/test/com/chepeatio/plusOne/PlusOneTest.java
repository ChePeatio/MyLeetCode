package test.com.chepeatio.plusOne;

import com.chepeatio.plusOne.PlusOne;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * PlusOne Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ê®¶þÔÂ 24, 2015</pre>
 */
@RunWith(Parameterized.class)
public class PlusOneTest {

    PlusOne test = new PlusOne();
    int[] param;
    int[] res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,2,3,4}, new int[]{1,2,3,5}},
                {new int[]{0}, new int[]{1}},
                {new int[]{9,9}, new int[]{1,0,0}},
                {new int[]{8,9}, new int[]{9,0}}
        });
    }

    public PlusOneTest(int[] parameter, int[] result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: plusOne(int[] digits)
     */
    @Test
    public void testPlusOne() throws Exception {
        Assert.assertArrayEquals(res, test.plusOne(param));
    }
}
