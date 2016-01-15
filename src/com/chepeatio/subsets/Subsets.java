package com.chepeatio.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Che Peatio on 2016/1/11.
 */
public class Subsets {
    /**
     * Recursive solution and easy to solve.
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0)
            return res;
        else if (nums.length == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            List<Integer> listEmpty = new ArrayList<>();
            res.add(list);
            res.add(listEmpty);
        } else {
            Arrays.sort(nums);
            int[] subNums = Arrays.copyOf(nums, nums.length-1);
            List<List<Integer>> lli = subsets(subNums);
            for (List<Integer> li : lli) {
                res.add(li);
                List<Integer> list = new ArrayList<>(li);
                list.add(nums[nums.length-1]);
                res.add(list);
            }
        }
        return res;
    }
}
