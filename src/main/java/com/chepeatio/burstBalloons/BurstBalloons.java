package com.chepeatio.burstBalloons;

/**
 * Created by Che Peatio on 2016/1/2.
 * Edited by Che Peatio on 2016/1/8.
 */
public class BurstBalloons {
    /**
     * I have to say it's a good problem of DP, since I had confused several days.
     * The DP solution like the article: https://leetcode.com/discuss/72216/share-some-analysis-and-explanations
     * 像这种求极值问题，我们一般都要考虑用动态规划Dynamic Programming来做
     * @param nums the list
     * @return max coins
     */
    public int maxCoins(int[] nums) {
        int[] noZeroNums = new int[nums.length + 2];
        int n = 1;
        for (int x : nums) if (x > 0) noZeroNums[n++] = x;
        noZeroNums[0] = noZeroNums[n++] = 1;

        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k)
            for (int left = 0; left < n - k; ++left) {
                int right = left + k;
                for (int i = left + 1; i < right; ++i)
                    dp[left][right] = Math.max(dp[left][right],
                            noZeroNums[left] * noZeroNums[i] * noZeroNums[right] + dp[left][i] + dp[i][right]);
            }
        return dp[0][n - 1];
    }
}
