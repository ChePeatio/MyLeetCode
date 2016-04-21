package test.com.chepeatio.nextPermutation;

import com.chepeatio.nextPermutation.NextPermutation;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * NextPermutation Tester.
 *
 * @author Che Peatio
 * @version 1.0
 * @since <pre>ËÄÔÂ 18, 2016</pre>
 */
@RunWith(Parameterized.class)
public class NextPermutationTest {

    NextPermutation test = new NextPermutation();
    int[] param;
    int[] res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,2,3,4,5}, new int[]{1,2,3,5,4}},
                {new int[]{}, new int[]{}},
                {new int[]{3,2,1}, new int[]{1,2,3}},
                {new int[]{1,1,5}, new int[]{1,5,1}}
        });
    }

    public NextPermutationTest(int[] param, int[] res) {
        this.param = param;
        this.res = res;
    }

    /**
     * Method: nextPermutation(int[] nums)
     */
    @Test
    public void testNextPermutation() throws Exception {
        test.nextPermutation(param);
        Assert.assertArrayEquals(res, param);
    }
} 
