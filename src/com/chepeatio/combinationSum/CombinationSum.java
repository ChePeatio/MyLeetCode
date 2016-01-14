package com.chepeatio.combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Che Peatio on 2016/1/14.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return recursiveCombinationSum(candidates, target);
    }

    private List<List<Integer>> recursiveCombinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (target < 0) {
            return lists;
        } else if (target == 0) {
            List<Integer> list = new ArrayList<>();
            lists.add(list);
            return lists;
        } else {
            for (int i=candidates.length-1; i>0; i--) {
                int[] subArray = new int[i+1];
                System.arraycopy(candidates, 0, subArray, 0, i + 1);
                List<List<Integer>> temp = combinationSum(subArray, target-candidates[i]);
                for (List<Integer> list : temp) {
                    list.add(candidates[i]);
                    lists.add(list);
                }
            }
            if (target % candidates[0] == 0) {
                List<Integer> list = new ArrayList<>();
                int time = target / candidates[0];
                while (time > 0) {
                    list.add(candidates[0]);
                    time--;
                }
                lists.add(list);
            }
        }
        return lists;
    }
}
