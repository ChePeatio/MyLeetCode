package com.chepeatio.majorityElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Che Peatio on 2016/1/21.
 */
public class MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length / 3;
        int cnt1=0, cnt2=0;
        int a=0, b=0;

        for(int num: nums){
            if (cnt1 == 0 || num == a){
                cnt1++;
                a = num;
            }
            else if (cnt2 == 0 || num==b){
                cnt2++;
                b = num;
            }
            else{
                cnt1--;
                cnt2--;
            }
        }

        cnt1=cnt2=0;
        for (int num : nums){
            if (num==a)   cnt1++;
            else if (num==b) cnt2++;
        }

        if (cnt1 > n)   res.add(a);
        if (cnt2 > n)   res.add(b);
        return res;
    }

    /**
     * My solution with O(nlogn) time complexity and O(1) space complexity.
     * @param nums target array
     * @return list of element whose count is more than n/3
     */
    public List<Integer> majorityElementSortSolution(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums==null || nums.length==0)
            return res;
        int n = nums.length / 3;
        Arrays.sort(nums);
        int count = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i-1] == nums[i])
                count++;
            else {
                if (count > n)
                    res.add(nums[i-1]);
                count = 1;
            }
        }
        if (count > n)
            res.add(nums[nums.length-1]);
        return res;
    }
}
