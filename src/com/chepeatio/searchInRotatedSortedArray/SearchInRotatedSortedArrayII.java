package com.chepeatio.searchInRotatedSortedArray;

import java.util.Arrays;

/**
 * Created by Che Peatio on 2015/12/28.
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length-1, m, index;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] == target)
                return true;
            if (nums[m] > nums[l]) {
                if (nums[l]<=target && target < nums[m]) {
                    index = Arrays.binarySearch(nums, l, m + 1, target);
                    return  index >= 0;
                } else {
                    l = m + 1;
                }
            } else if (nums[m] < nums[l]){
                if (nums[m]<target && target<=nums[r]) {
                    index = Arrays.binarySearch(nums, m, r+1, target);
                    return index >= 0;
                } else {
                    r = m -1;
                }
            } else {
                l++;
            }
        }
        return false;
    }
}
