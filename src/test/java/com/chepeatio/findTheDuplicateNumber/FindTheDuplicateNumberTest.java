package com.chepeatio.findTheDuplicateNumber;

import com.chepeatio.findTheDuplicateNumber.FindTheDuplicateNumber;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * FindTheDuplicateNumber Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ê®Ò»ÔÂ 16, 2015</pre>
 */
@RunWith(Parameterized.class)
public class FindTheDuplicateNumberTest {

    FindTheDuplicateNumber test = new FindTheDuplicateNumber();
    int[] param;
    int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2,2,2,4}, 2},
                {new int[]{1, 2, 3, 4, 5, 5}, 5},
                {new int[]{1,1}, 1}
        });
    }

    public FindTheDuplicateNumberTest(int[] parameter, int result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: findDuplicate(int[] nums)
     */
    @Test
    public void testFindDuplicate() throws Exception {
        Assert.assertEquals(res, test.findDuplicate(param));
    }

    /**
     * Method: findDuplicateBS(int[] nums)
     */
    @Test
    public void testFindDuplicateBS() throws Exception {
        Assert.assertEquals(res, test.findDuplicateBS(param));
    }
} 
