package com.chepeatio.singleNumber;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by CheKedar on 2015/10/20.
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        Set<Integer> theNumber = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            if (!theNumber.contains(nums[i])) {
                theNumber.add(nums[i]);
            } else {
                theNumber.remove(nums[i]);
            }
        }
        Iterator<Integer> iterator = theNumber.iterator();
        return iterator.next();
    }

    /**
     * 好的解法，巧用XOR运算对相同bit化0的作用
     * @param nums
     * @return
     */
    public int singleNumberBS(int[] nums) {
        int res = nums[0];
        for (int i=1; i<nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
}
