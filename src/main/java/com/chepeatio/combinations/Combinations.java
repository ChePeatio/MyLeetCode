package com.chepeatio.combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Che Peatio on 2015/12/18.
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k > n || k < 1)
            return res;
        if (k == 1) {
            for (int i=1; i<=n ;i++) {
                List<Integer> li = new ArrayList<>();
                li.add(i);
                res.add(li);
            }
            return res;
        } else {
            for (int i=n; i>=k; i--) {
                List<List<Integer>> lli = combine(i-1, k-1);
                for (List<Integer> li : lli) {
                    li.add(i);
                    res.add(li);
                }
            }
            return res;
        }
    }
}
