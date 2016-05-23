package test.com.chepeatio.pow_x_n;

import com.chepeatio.pow_x_n.Pow_x_n;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Pow_x_n Tester.
 *
 * @author Che Peatio
 * @version 1.0
 * @since <pre>ÎåÔÂ 23, 2016</pre>
 */
@RunWith(Parameterized.class)
public class Pow_x_nTest {

    Pow_x_n test = new Pow_x_n();
    double param1;
    int param2;
    double res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {0.23, 0, Math.pow(0.23, 0)},
                {0.23, 13, Math.pow(0.23, 13)},
                {0.23, -3, Math.pow(0.23, -3)},
                {0.23, 1, 0.23},
                {1.0, -2147483648, Math.pow(1.0, -2147483648)}
        });
    }

    public Pow_x_nTest(double parameter1, int parameter2, double result) {
        param1 = parameter1;
        param2 = parameter2;
        res = result;
    }

    /**
     * Method: myPow(double x, int n)
     */
    @Test
    public void testMyPow() throws Exception {
        Assert.assertEquals(res, test.myPow(param1, param2), 0.0001);
    }
} 
