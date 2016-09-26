package com.chepeatio.bulbSwitcher;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * BulbSwitcher Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ò»ÔÂ 9, 2016</pre>
 */
@RunWith(Parameterized.class)
public class BulbSwitcherTest {

    BulbSwitcher test = new BulbSwitcher();
    int param;
    int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {0, 0},
                {1, 1},
                {3, 1},
                {10, 3}
        });
    }

    public BulbSwitcherTest(int parameter, int result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: bulbSwitch(int n)
     */
    @Test
    public void testBulbSwitch() throws Exception {
        Assert.assertEquals(res, test.bulbSwitch(param));
    }
} 
