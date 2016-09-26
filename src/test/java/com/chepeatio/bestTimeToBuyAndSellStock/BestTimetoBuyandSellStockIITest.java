package com.chepeatio.bestTimeToBuyAndSellStock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/** 
* BestTimetoBuyandSellStockII Tester. 
* 
* @author <Authors name> 
* @since <pre>十月 27, 2015</pre> 
* @version 1.0 
*/
@RunWith(Parameterized.class)
public class BestTimetoBuyandSellStockIITest {

    private BestTimetoBuyandSellStockII test = new BestTimetoBuyandSellStockII();
    private int[] param;
    private int result;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{5, 7, 3, 9, 2, 1, 8}, 15},
                {new int[]{}, 0},
                {new int[]{9}, 0},
                {new int[]{9, 8, 7, 6, 5, 4}, 0},
                {new int[]{1, 2, 3, 4, 5, 6}, 5}
        });
    }

    // 构造函数，对变量进行初始化
    public BestTimetoBuyandSellStockIITest(int[] param, int result) {
        this.param = param;
        this.result = result;
    }

    @Test
    public void TestMaxProfit() {
        assertEquals(result, test.maxProfit(param));
    }

    @Test
    public void TestMaxProfitBS() {
        assertEquals(result, test.maxProfitBS(param));
    }
}