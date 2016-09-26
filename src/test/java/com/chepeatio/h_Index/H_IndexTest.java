package com.chepeatio.h_Index;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * H_Index Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ê®¶þÔÂ 25, 2015</pre>
 */
@RunWith(Parameterized.class)
public class H_IndexTest {

    private H_Index test = new H_Index();
    private int[] param;
    private int res;

    public H_IndexTest(int[] parameter, int result) {
        param = parameter;
        res = result;
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 6, 4, 6}, 3},
                {new int[]{10, 10, 10, 10, 10}, 5},
                {new int[]{1, 1, 2, 1, 1}, 1},
                {new int[]{1, 1, 11, 3, 1}, 2},
                {new int[]{0}, 0},
                {new int[]{1,1000,300,3,11,0}, 3}
        });
    }

    /**
     * Method: hIndex(int[] citations)
     */
    @Test
    public void testHIndex() throws Exception {
        Assert.assertEquals(res, test.hIndex(param));
    }
} 
