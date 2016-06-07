package test.com.chepeatio.sqrt_x;

import com.chepeatio.sqrt_x.Sqrt_x;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Sqrt_x Tester.
 *
 * @author Che Peatio
 * @version 1.0
 * @since <pre>ÁùÔÂ 7, 2016</pre>
 */
@RunWith(Parameterized.class)
public class Sqrt_xTest {

    private Sqrt_x test = new Sqrt_x();
    private int param;
    private int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {38, 6},
                {1366, 36},
                {768, 27},
                {9, 3},
                {18, 4},
                {2147395599, 46339}
        });
    }

    public Sqrt_xTest(int parameter, int result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: mySqrt(int x)
     */
    @Test
    public void testMySqrt() throws Exception {
        Assert.assertEquals(res, test.mySqrt(param));
    }
} 
