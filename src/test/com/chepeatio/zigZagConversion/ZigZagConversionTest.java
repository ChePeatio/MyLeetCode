package test.com.chepeatio.zigZagConversion;

import com.chepeatio.zigZagConversion.ZigZagConversion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * ZigZagConversion Tester.
 *
 * @author Che Peatio
 * @version 1.0
 * @since <pre>ËÄÔÂ 23, 2016</pre>
 */
@RunWith(Parameterized.class)
public class ZigZagConversionTest {

    ZigZagConversion test = new ZigZagConversion();
    String param1;
    int param2;
    String res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {"PAYPALISHIRING", 3, "PAHNAPLSIIGYIR"},
                {"PAYPALISHIRING", 1, "PAYPALISHIRING"},
                {"PAYPALISHIRINGCKDABCDE", 4, "PINBALSIGACYAHRCDDPIKE"}
        });
    }

    public ZigZagConversionTest(String parameter1, int parameter2, String result) {
        param1 = parameter1;
        param2 = parameter2;
        res = result;
    }

    /**
     * Method: convert(String s, int numRows)
     */
    @Test
    public void testConvert() throws Exception {
        Assert.assertEquals(res, test.convert(param1, param2));
    }
} 
