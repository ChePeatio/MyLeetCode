package com.chepeatio.maximumProductSubarray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Che Peatio on 2015/10/30.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int temp;
        List<Integer> part = new ArrayList<>();
        boolean existZero = false;

        for (int num : nums) {
            if (num != 0) {
                part.add(num);
            } else {
                existZero = true;
                temp = partMaxProduct(part);
                if (temp > result) {
                    result = temp;
                }
                part.clear();
            }
        }

        temp = partMaxProduct(part);
        if (temp > result) {
            result = temp;
        }

        if (result < 0 && existZero)
            result = 0;

        return result;
    }

    private int partMaxProduct(List<Integer> part) {
        if (part.size() == 0)
            return Integer.MIN_VALUE;
        if (part.size() == 1)
            return part.get(0);

        int partMax = 1;
        List<Integer> neg = new ArrayList<>();
        for (int i=0; i<part.size(); i++) {
            partMax *= part.get(i);
            if (part.get(i) < 0)
                neg.add(i);
        }
        if (partMax > 0)
            return partMax;

        int leftMax = 1;
        for (int i=0; i<neg.get(neg.size()-1); i++) {
            leftMax *= part.get(i);
        }

        int rightMax = 1;
        for (int i=neg.get(0)+1; i<part.size(); i++) {
            rightMax *= part.get(i);
        }

        return leftMax > rightMax ? leftMax : rightMax;
    }

    public int maxProductBS(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = 0;
        int min = 0;
        int maxSoFar = 0;
        for (int num : nums) {
            if (num == 0) {
                max = 0;
                min = 0;
            } else if (num > 0) {
                if (max != 0) {
                    max *= num;
                } else {
                    max = num;
                }
                min *= num;
            } else {
                int temp = max;
                max = min * num;
                if (temp != 0) {
                    min = temp * num;
                } else {
                    min = num;
                }
            }
            if (max > maxSoFar) {
                maxSoFar = max;
            }
        }
        return maxSoFar;
    }
}
