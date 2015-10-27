package test.com.chepeatio.bestTimetoBuyandSellStock;

import com.chepeatio.bestTimetoBuyandSellStock.BestTimetoBuyandSellStock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by CheKedar on 2015/10/19.
 */
@RunWith(Parameterized.class)
public class BestTimetoBuyandSellStockTest {

    BestTimetoBuyandSellStock test = new BestTimetoBuyandSellStock();
    int[] param;
    int result;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{5,7,3,9,2,1,8}, 7},
                {new int[]{}, 0},
                {new int[]{9,8,7,6,5,4}, 0}
        });
    }

    // 构造函数，对变量进行初始化
    public BestTimetoBuyandSellStockTest(int[] param, int result) {
        this.param = param;
        this.result = result;
    }

    @Test
    public void TestMaxProfit() {
        assertEquals(result, test.maxProfit(param));
    }
}