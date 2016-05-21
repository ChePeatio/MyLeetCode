package com.chepeatio.combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Che Peatio on 2016/5/21.
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = utilCombination(candidates, candidates.length, target);
        return res==null ? new ArrayList<>() : res;
    }

    private List<List<Integer>> utilCombination(int[] candidates, int length, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (target == 0)
            return res;

        if (target < 0 || length < 1 || target < candidates[0] || target > arraySum(candidates, length))
            return null;

        for (int i=length-1; i>=0; i--) {
            if (i==length-1 || candidates[i]!=candidates[i+1]) {
                List<List<Integer>> temp = utilCombination(candidates, i, target-candidates[i]);
                if (temp != null) {
                    if (temp.size() == 0) {
                        List<Integer> li = new ArrayList<>();
                        li.add(candidates[i]);
                        res.add(li);
                    } else {
                        for (List<Integer> li : temp) {
                            li.add(candidates[i]);
                            res.add(li);
                        }
                    }
                }
            }
        }
        return res.size()==0 ? null : res;
    }

    private int arraySum(int[] arr, int len) {
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
