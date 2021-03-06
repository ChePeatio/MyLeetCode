package com.chepeatio.missingNumber;

import com.chepeatio.missingNumber.MissingNumber;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * MissingNumber Tester.
 *
 * @author Che Peatio
 * @version 1.0
 * @since <pre>ʮһ�� 7, 2015</pre>
 */
@RunWith(Parameterized.class)
public class MissingNumberTest {

    private MissingNumber test = new MissingNumber();
    private int[] param;
    private int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 3, 4, 0, 7, 5}, 6},
                {new int[]{1, 2, 3, 5, 6, 4}, 0},
                {new int[]{0, 2}, 1},
                {new int[]{0, 1}, 2}
        });
    }

    public MissingNumberTest(int[] parameter, int result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: missingNumber(int[] nums)
     */
    @Test
    public void testMissingNumber() throws Exception {
        Assert.assertEquals(res, test.missingNumber(param));
    }
} 
