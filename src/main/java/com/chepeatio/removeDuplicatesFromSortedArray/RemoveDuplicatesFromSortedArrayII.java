package com.chepeatio.removeDuplicatesFromSortedArray;

/**
 * Created by Che Peatio on 2015/12/26.
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums.length==0)
            return 0;
        boolean dup = false;
        int cur = 0;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                if (!dup) {
                    dup = true;
                    cur++;
                }
            } else {
                dup = false;
                cur++;
            }
            nums[cur] = nums[i];
        }
        return ++cur;
    }
}
