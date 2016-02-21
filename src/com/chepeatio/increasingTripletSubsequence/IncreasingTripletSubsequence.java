package com.chepeatio.increasingTripletSubsequence;

/**
 * Created by Che Peatio on 2016/2/21.
 */
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int num : nums) {
            if (min >= num) min = num;
            else if (secondMin >= num) secondMin = num;
            else return true;
        }
        return false;
    }

    public boolean increasingTripletBadSolution(int[] nums) {
        int len = nums.length;
        for (int i=0; i<len-2; i++) {
            for (int j=i+1; j<len-1; j++) {
                if (nums[i]<nums[j]) {
                    for (int k=j+1; k<len; k++) {
                        if (nums[j]<nums[k])
                            return true;
                    }
                }
            }
        }
        return false;
    }
}
