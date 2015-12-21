package com.chepeatio.houseRobber;

/**
 * Created by Che Peatio on 2015/12/21.
 */
public class HouseRobber {

    /**
     * dynamic programming problem
     * The solution is finding the recurrence formula.
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            int m = a, n = b;
            a = n + num;
            b = Math.max(m, n);
        }
        return Math.max(a, b);
    }

    /**
     * original solution
     * @param nums
     * @return
     */
    public int robLongTimeSolution(int[] nums) {
        if (nums==null || nums.length==0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[0] < nums[1] ? nums[1] : nums[0];
        for (int i=2; i<nums.length; i++) {
            dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
        }
        return dp[nums.length-1];
    }
}
