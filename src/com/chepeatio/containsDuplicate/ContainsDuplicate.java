package com.chepeatio.containsDuplicate;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Che Peatio on 2015/10/29.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> si = new HashSet<>(nums.length);
        for (int num : nums) {
            si.add(num);
        }
        return si.size() != nums.length;
    }
}
