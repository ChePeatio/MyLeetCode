package com.chepeatio.majorityElement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Che Peatio on 2015/11/3.
 */
public class MajorityElement {
    public int majorityElementBAD(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int max = nums[0];
        for (int num : nums) {
            if (count.containsKey(num)) {
                count.put(num, count.get(num)+1);
                if (count.get(max) < count.get(num))
                    max = num;
            }
            else
                count.put(num, 1);
        }
        return max;
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public int majorityElementBS(int[] nums) {
        int cur = nums[0];
        for(int i = 1, count = 1; i < nums.length; i++){
            if(nums[i] == cur) count++;
            else count--;
            if(count == -1){
                cur = nums[i];
                count = 1;
            }
        }
        return cur;
    }
}
