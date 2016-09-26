package com.chepeatio.romanToInteger;

import com.chepeatio.romanToInteger.romanToInteger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * romanToInteger Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ê®Ò»ÔÂ 12, 2015</pre>
 */
@RunWith(Parameterized.class)
public class RomanToIntegerTest {

    romanToInteger test = new romanToInteger();
    String param;
    int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {"I", 1},
                {"XIX", 19},
                {"MCDXXXVII", 1437},
                {"MMMCCCXXXIII", 3333},
                {"XCIX", 99},
                {"CI", 101},
                {"XL", 40},
                {"CII", 102},
                {"CM", 900},
                {"MDCCCLXXX", 1880}
        });
    }

    public RomanToIntegerTest(String parameter, int result) {
        param = parameter;
        res = result;
    }
    /**
     * Method: romanToInt(String s)
     */
    @Test
    public void testRomanToInt() throws Exception {
        Assert.assertEquals(res, test.romanToInt(param));
    }
} 
