package com.chepeatio.findMinimumInRotatedSortedArray;

import com.chepeatio.Main;

/**
 * Created by Che Peatio on 2015/11/19.
 */
public class FindMinimumInRotatedSortedArray {

    public int findMinBS(int[] nums) {
        if (nums==null || nums.length==0) {
            return -1;
        }
        int min = nums[0];
        int l = 0;
        int r = nums.length - 1;
        int m;
        while (l < r) {
            m = (l + r) / 2;
            if (nums[l] < nums[m]) {
                min = nums[l] < min ? nums[l] : min;
                l = m + 1;
            } else if (nums[l] > nums[m]) {
                min = nums[m] < min ? nums[m] : min;
                r = m - 1;
            } else {
                min = nums[l] < min ? nums[l] : min;
                min = nums[r] < min ? nums[r] : min;
                return min;
            }
        }
        min = nums[l] < min ? nums[l] : min;
        return min;
    }

    public int findMin(int[] nums) {
        if (nums==null || nums.length == 0)
            return -1;
        int min = nums[0];
        for (int num : nums) {
            if (min > num)
                min = num;
        }
        return min;
    }
}
