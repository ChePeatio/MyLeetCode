package com.chepeatio.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Che Peatio on 2016/1/17.
 * Edited by Che Peatio on 2016/1/18.
 */
public class SubsetsII {

    /**
     * More easy solution.
     * @param nums number list
     * @return list of list
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> temp;
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0)
            return result;
        Arrays.sort(nums);
        int pos = 0;
        result.add(new ArrayList<>());
        while (pos < nums.length) {
            temp = new ArrayList<>();
            int count = 0;
            while (pos+count<nums.length && nums[pos]==nums[pos+count]) count++;
            for (List<Integer> list : result) {
                temp.add(list);
                for (int j=1; j<=count; j++) {
                    List<Integer> li = new ArrayList<>(list);
                    for (int k=0; k<j; k++)
                        li.add(nums[pos]);
                    temp.add(li);
                }
            }
            pos += count;
            result = temp;
        }
        return result;
    }

    /**
     * My solution with recursive process.
     * @param nums number list
     * @return a list of list.
     */
    public List<List<Integer>> subsetsWithDupRecursiveSolution(int[] nums) {
        if (nums.length == 0)
            return null;
        Arrays.sort(nums);
        int[] array = new int[nums.length];
        int[] count = new int[nums.length];
        int len=0, temp=nums[0];
        array[0] = nums[0];
        for (int num : nums) {
            if (num == temp) {
                count[len]++;
            } else {
                array[++len] = num;
                temp = num;
                count[len]++;
            }
        }
        return recursiveSolveSubSets(len, array, count);
    }

    private List<List<Integer>> recursiveSolveSubSets(int length, int[] array, int[] count) {
        List<List<Integer>> res = new ArrayList<>();
        if (length == 0) {
            for (int i=0; i<=count[length]; i++) {
                List<Integer> list = new ArrayList<>();
                for (int j=0; j<i; j++) {
                    list.add(array[length]);
                }
                res.add(list);
            }
        } else {
            List<List<Integer>> lists = recursiveSolveSubSets(length-1, array, count);
            for (List<Integer> list : lists) {
                res.add(list);
                for (int i=1; i<=count[length]; i++) {
                    List<Integer> li = new ArrayList<>(list);
                    for (int j=0; j<i; j++) {
                        li.add(array[length]);
                    }
                    res.add(li);
                }
            }
        }
        return res;
    }
}
