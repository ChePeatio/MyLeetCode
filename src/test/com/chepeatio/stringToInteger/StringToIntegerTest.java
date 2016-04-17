package test.com.chepeatio.stringToInteger;

import com.chepeatio.stringToInteger.StringToInteger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * StringToInteger Tester.
 *
 * @author Che Peatio
 * @version 1.0
 * @since <pre>ËÄÔÂ 16, 2016</pre>
 */
@RunWith(Parameterized.class)
public class StringToIntegerTest {

    StringToInteger test = new StringToInteger();
    String param;
    int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {"", 0},
                {"1122334", 1122334},
                {"0001", 1},
                {"-10101", -10101},
                {"+1111", 1111},
                {"+-2", 0},
                {"   010", 10},
                {"2147483648", 2147483647},
                {"-2147483647", -2147483647}
        });
    }

    public StringToIntegerTest(String param, int res) {
        this.param = param;
        this.res = res;
    }

    /**
     * Method: myAtoi(String str)
     */
    @Test
    public void testMyAtoi() throws Exception {
        Assert.assertEquals(res, test.myAtoi(param));
    }
} 
