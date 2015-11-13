package test.com.chepeatio.integerToRoman;

import com.chepeatio.integerToRoman.IntegerToRoman;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * IntegerToRoman Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ê®Ò»ÔÂ 13, 2015</pre>
 */
@RunWith(Parameterized.class)
public class IntegerToRomanTest {

    IntegerToRoman test = new IntegerToRoman();
    int param;
    String res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {1, "I"},
                {19, "XIX"},
                {1437, "MCDXXXVII"},
                {3333, "MMMCCCXXXIII"},
                {99, "XCIX"},
                {101, "CI"},
                {40, "XL"},
                {102, "CII"},
                {900, "CM"},
                {1880, "MDCCCLXXX"}
        });
    }

    public IntegerToRomanTest(int parameter, String result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: intToRoman(int num)
     */
    @Test
    public void testIntToRoman() throws Exception {
        Assert.assertEquals(res, test.intToRoman(param));
    }

    /**
     * Method: intToRomanES(int num)
     */
    @Test
    public void testIntToRomanES() throws Exception {
        Assert.assertEquals(res, test.intToRomanES(param));
    }
} 
