package com.chepeatio.containsDuplicate;

/**
 * Created by Che Peatio on 2016/1/12.
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i=1; i<nums.length; i++) {
            for (int j=1; j<=k; j++) {
                if (i-j < 0)
                    break;
                if (nums[i] == nums[i-j])
                    return true;
            }
        }
        return false;
    }
}
