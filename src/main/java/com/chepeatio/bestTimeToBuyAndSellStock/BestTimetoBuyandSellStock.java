package com.chepeatio.bestTimeToBuyAndSellStock;

/**
 * Created by Che Peatio on 2015/10/26.
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, min = Integer.MAX_VALUE;

        for (int i=0; i<prices.length; i++) {
            if (prices[i] < min)
                min = prices[i];
            else
                maxProfit = Math.max(maxProfit, prices[i]-min);
        }
        return maxProfit;
    }
}
