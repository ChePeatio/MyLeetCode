package com.chepeatio.missingNumber;

/**
 * Created by Che Peatio on 2015/11/7.
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int max = 0;
        int min = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            max = max < num ? num : max;
            min = min > num ? num : min;
        }
        int result = max * (max + 1) / 2 - sum;
        if (result == 0 && min == 0)
            return max+1;
        return result;
    }
}
