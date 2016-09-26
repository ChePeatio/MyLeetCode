package com.chepeatio.uglyNumber;

import com.chepeatio.uglyNumber.UglyNumber;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * UglyNumber Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ê®Ò»ÔÂ 22, 2015</pre>
 */
@RunWith(Parameterized.class)
public class UglyNumberTest {

    UglyNumber test = new UglyNumber();
    int param;
    boolean res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {0, false},
                {4096, true},
                {1, true},
                {19, false}
        });
    }

    public UglyNumberTest(int parameter, boolean result) {
        param = parameter;
        res = result;
    }
    /**
     * Method: isUgly(int num)
     */
    @Test
    public void testIsUgly() throws Exception {
        Assert.assertEquals(res, test.isUgly(param));
    }


} 
