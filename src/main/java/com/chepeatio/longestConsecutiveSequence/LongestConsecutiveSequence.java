package com.chepeatio.longestConsecutiveSequence;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Che Peatio on 2015/12/31.
 */
public class LongestConsecutiveSequence {
    /**
     * At first, I had no idea to solve the problem, and I didn't solve the problem finally.
     * This is a solution in the discuss of leetcode.
     * @param nums unsorted array
     * @return longest length of consecutive sequence.
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int num : nums)
            set.add(num);
        for (int num : nums) {
            if (!set.contains(num-1)) {
                int val = num;
                while (set.remove(val++));
                val = val - 1 - num;
                res = res > val ? res : val;
            }
        }
        return res;
    }
}
