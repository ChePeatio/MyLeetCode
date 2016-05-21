package com.chepeatio;

import com.chepeatio.combinationSum.CombinationSumII;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Hello, LeetCode!");

        CombinationSumII test = new CombinationSumII();
        List<List<Integer>> res = test.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        if (res != null)
            for (List<Integer> li : res) {
                for (int i : li)
                    System.out.print(i + " ");
                System.out.println();
            }
    }
}
