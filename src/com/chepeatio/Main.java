package com.chepeatio;

import com.chepeatio.combinationSum.CombinationSumII;
import com.chepeatio.permutations.PermutationsII;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Hello, LeetCode!");

        PermutationsII test = new PermutationsII();
        List<List<Integer>> lli = test.permuteUniqueImprove(new int[]{1,1,2});
        for (List<Integer> li : lli) {
            for (int i : li) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
