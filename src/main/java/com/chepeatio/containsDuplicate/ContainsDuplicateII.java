package com.chepeatio.containsDuplicate;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Che Peatio on 2016/1/12.
 */
public class ContainsDuplicateII {

    /**
     * HashSet solution and most efficient solution.
     * @param nums number list
     * @param k the most different
     * @return if contains nearby duplicate
     */
/*    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            if (i > k)
                hashSet.remove(nums[i-k-1]);
            if (!hashSet.add(nums[i]))
                return true;
        }
        return false;
    }*/

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Integer value;
        for (int i=0; i<nums.length; i++) {
            if ((value=hashMap.put(nums[i], i)) != null) {
                if (i - value <= k)
                    return true;
            }
        }
        return false;
    }
}
