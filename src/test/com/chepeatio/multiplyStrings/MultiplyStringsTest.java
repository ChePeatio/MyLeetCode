package test.com.chepeatio.multiplyStrings;

import com.chepeatio.multiplyStrings.MultiplyStrings;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * MultiplyStrings Tester.
 *
 * @author Che Peatio
 * @version 1.0
 * @since <pre>ÎåÔÂ 21, 2016</pre>
 */
@RunWith(Parameterized.class)
public class MultiplyStringsTest {

    MultiplyStrings test = new MultiplyStrings();
    String param1;
    String param2;
    String res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {"999999999999999999", "0", "0"},
                {"123412341234", "12341234", "1523060581656642756"},
                {"99", "100", "9900"}
        });
    }

    public MultiplyStringsTest(String parameter1, String parameter2, String result) {
        param1 = parameter1;
        param2 = parameter2;
        res = result;
    }

    /**
     * Method: multiply(String num1, String num2)
     */
    @Test
    public void testMultiply() throws Exception {
        Assert.assertEquals(res, test.multiplyFaster(param1, param2));
    }
} 
