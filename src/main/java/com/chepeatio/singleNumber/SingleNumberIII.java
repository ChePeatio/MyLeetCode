package com.chepeatio.singleNumber;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Che Peatio on 2015/10/28.
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        Set<Integer> bag = new HashSet<>();
        for (int x : nums) {
            if (bag.contains(x))
                bag.remove(x);
            else
                bag.add(x);
        }
        int i=0;
        for (int val : bag) {
            result[i++] = val;
        }
        return result;
    }

    public int[] singleNumberBS(int[] nums) {
        int[] result = new int[2];
        int temp = 0;
        for (int num : nums) {
            temp ^= num;
        }

        temp &= -temp;

        for (int num: nums) {
            if ((temp & num) != 0)
                result[0] ^= num;
            else
                result[1] ^= num;
        }
        return result;
    }
}
