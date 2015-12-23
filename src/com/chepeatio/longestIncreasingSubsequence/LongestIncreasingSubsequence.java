package com.chepeatio.longestIncreasingSubsequence;

/**
 * Created by Che Peatio on 2015/12/23.
 */
public class LongestIncreasingSubsequence {

    /**
     * DP solution in my mind,
     * and there is one solution better than DP in https://leetcode.com/discuss/71129/space-log-time-short-solution-without-additional-memory-java
     * however I can't catch the idea of the solution.
     * @param nums the sequence
     * @return length
     */
    public int lengthOfLIS(int[] nums) {
        if (nums==null || nums.length==0)
            return 0;
        int res = 0;
        int[] list = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            for (int j=i-1; j>=0; j--) {
                if (nums[i]>nums[j]) {
                    list[i] = list[i] > list[j]+1 ? list[i] : list[j]+1;
                    res = res > list[i] ? res : list[i];
                }
            }
        }
        return res+1;   // the array initial with 0 while it should be 1.
    }
}
