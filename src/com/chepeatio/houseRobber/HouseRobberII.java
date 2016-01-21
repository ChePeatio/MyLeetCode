package com.chepeatio.houseRobber;

import java.util.Arrays;

/**
 * Created by Che Peatio on 2016/1/21.
 */
public class HouseRobberII {

    public int rob(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(utilRob(nums, 0, nums.length - 2), utilRob(nums, 1, nums.length - 1));
    }

    private int utilRob(int[] num, int lo, int hi) {
        int include = 0, exclude = 0;
        for (int j = lo; j <= hi; j++) {
            int i = include, e = exclude;
            include = e + num[j];
            exclude = Math.max(e, i);
        }
        return Math.max(include, exclude);
    }

    /**
     * My original solution with
     * @param nums cash of robbed houses
     * @return max cashes
     */
    public int robOriginalSolution(int[] nums) {
        if (nums==null || nums.length==0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return nums[0] > nums[1] ? nums[0] : nums[1];

        int res;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[0] > nums[1] ? nums[0] : nums[1];
        for (int i=2; i<nums.length-1; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        res = dp[nums.length-2];

        dp[1] = nums[1];
        dp[2] = nums[2] > nums[1] ? nums[2] : nums[1];
        for (int i=3; i<nums.length; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        res = res > dp[nums.length-1] ? res : dp[nums.length-1];
        return res;
    }
}
