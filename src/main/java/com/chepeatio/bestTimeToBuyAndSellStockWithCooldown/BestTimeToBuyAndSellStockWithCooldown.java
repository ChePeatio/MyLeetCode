package com.chepeatio.bestTimeToBuyAndSellStockWithCooldown;

/**
 * Created by Che Peatio on 2015/12/5.
 * Edited by Che Peatio on 2015/12/7.
 */
public class BestTimeToBuyAndSellStockWithCooldown {

    /**
     * DP题目，完全想不通整个思路，参考了https://leetcode.com/discuss/71354/share-my-thinking-process
     * 完成了这次的题目
     * @param prices 多天股票的价格
     * @return 最大收益
     */
    public int maxProfit(int[] prices) {
        int buy = Integer.MIN_VALUE, pre_buy, sell = 0, pre_sell = 0;
        for (int price : prices) {
            pre_buy = buy;
            buy = Math.max(pre_sell - price, pre_buy);
            pre_sell = sell;
            sell = Math.max(pre_buy + price, pre_sell);
        }
        return sell;
    }
}
