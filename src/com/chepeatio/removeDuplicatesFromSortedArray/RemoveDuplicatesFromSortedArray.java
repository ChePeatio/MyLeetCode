package com.chepeatio.removeDuplicatesFromSortedArray;

/**
 * Created by Che Peatio on 2015/12/22.
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums==null || nums.length==0)
            return 0;
        int pos = 0;
        int cur = nums[0];
        for (int i=1; i<nums.length; i++) {
            if (cur != nums[i]) {
                cur = nums[i];
                nums[++pos] = nums[i];
            }
        }
        return ++pos;
    }
}
