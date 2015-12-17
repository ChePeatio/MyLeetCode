package com.chepeatio.findPeakElement;

/**
 * Created by Che Peatio on 2015/12/17.
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int res = -1;
        if (nums==null || nums.length==0)
            return res;
        res = 0;
        for (int i=1; i<nums.length; i++) {
            if (nums[res] > nums[i])
                return res;
            else
                res = i;
        }
        return res;
    }
}
