package com.chepeatio.findMinimumInRotatedSortedArray;

/**
 * Created by Che Peatio on 2015/12/6.
 */
public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        if (nums==null || nums.length==0)
            return -1;
        if (nums[0] < nums[nums.length-1])
            return nums[0];
        int left = 0, right = nums.length-1;
        int medium = (left + right) / 2;
        while (left != medium) {
            if (nums[left] == nums[medium] && nums[left] == nums[right])
                break;
            if (nums[medium] < nums[left]) {
                right = medium;
                medium = (left + right) / 2;
            } else {
                left = medium;
                medium = (left + right) / 2;
            }
        }
        if (left != medium) {
            int min = nums[left];
            for (int i=left; i<right; i++) {
                if (min > nums[i])
                    min = nums[i];
            }
            return min;
        }

        return nums[medium] < nums[right] ? nums[medium] : nums[right];
    }
}
