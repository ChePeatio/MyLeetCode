package com.chepeatio.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Che Peatio on 2015/12/2.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        if (nums.length == 1) {
            List<Integer> val = new ArrayList<>();
            val.add(nums[0]);
            res.add(val);
            return res;

        } else if (nums.length > 1) {
            for (int cur = 0; cur < nums.length; cur++) {
                int[] rest = new int[nums.length - 1];
                for (int pos = 0; pos < nums.length; pos++) {
                    if (pos < cur) {
                        rest[pos] = nums[pos];
                    } else if (pos > cur) {
                        rest[pos - 1] = nums[pos];
                    }
                }
                List<List<Integer>> ret = permute(rest);
                for (List<Integer> aRet : ret) {
                    List<Integer> val = new ArrayList<>();
                    val.add(nums[cur]);
                    val.addAll(aRet);
                    res.add(val);
                }
            }
        }
        return res;
    }
}
