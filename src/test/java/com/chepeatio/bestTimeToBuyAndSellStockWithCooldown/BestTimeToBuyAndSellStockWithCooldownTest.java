package com.chepeatio.bestTimeToBuyAndSellStockWithCooldown;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * BestTimeToBuyAndSellStockWithCooldown Tester.
 *
 * @author Che Peatio
 * @version 1.0
 * @since <pre>Ê®¶þÔÂ 7, 2015</pre>
 */
@RunWith(Parameterized.class)
public class BestTimeToBuyAndSellStockWithCooldownTest {

    BestTimeToBuyAndSellStockWithCooldown test = new BestTimeToBuyAndSellStockWithCooldown();
    int[] param;
    int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 3, 0, 2}, 3},
                {new int[]{1000, 0, 1000}, 1000}
        });
    }

    public BestTimeToBuyAndSellStockWithCooldownTest(int[] parameter, int result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: maxProfit(int[] prices)
     */
    @Test
    public void testMaxProfit() throws Exception {
        Assert.assertEquals(res, test.maxProfit(param));
    }
} 
