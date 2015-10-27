package com.chepeatio.bestTimetoBuyandSellStock;

/**
 * Created by Che Peatio on 2015/10/27.
 */
public class BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        if (prices==null || prices.length==0)
            return maxProfit;

        int recentMin = -1;

        for (int i=0; i<prices.length-1; i++) {
            if (prices[i]>prices[i+1] && recentMin!=-1) {
                maxProfit += (prices[i] - recentMin);
                recentMin = -1;
            } else if (prices[i]<prices[i+1] && recentMin==-1) {
                recentMin = prices[i];
            }
        }

        if (recentMin!=-1)
            maxProfit += (prices[prices.length-1] - recentMin);

        return maxProfit;
    }

    public int maxProfitBS(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int profitToday = prices[i] - prices[i - 1];
            profit += profitToday > 0 ? profitToday : 0;
        }
        return profit;
    }
}
