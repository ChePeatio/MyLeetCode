package com.chepeatio.combinationSum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Che Peatio on 2015/12/17.
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k <= 0)
            return null;
        return utilCombinationSum(k, n, 1);
    }

    private List<List<Integer>> utilCombinationSum(int k, int n, int begin) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0 || begin > n)
            return res;
        if ((9 + 9 - k + 1) * k / 2 < n || (1 + k) * k / 2 > n)
            return res;

        if (k == 1) {
            List<Integer> li = new ArrayList<>();
            li.add(n);
            res.add(li);
        } else {
            int pos = 9 - k + 1;
            for (int i = begin; i<=pos&&i<=n; i++) {
                List<List<Integer>> temp = utilCombinationSum(k - 1, n - i, i + 1);
                if (temp != null && temp.size() > 0) {
                    for (List<Integer> li : temp) {
                        List<Integer> nli = new ArrayList<>();
                        nli.add(i);
                        nli.addAll(li);
                        res.add(nli);
                    }
                }
            }
        }
        return res;
    }
}
