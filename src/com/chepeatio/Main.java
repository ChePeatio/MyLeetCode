package com.chepeatio;

import com.chepeatio.combinationSum.CombinationSumIII;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello, LeetCode!");
        CombinationSumIII test = new CombinationSumIII();
        List<List<Integer>> res = test.combinationSum3(3,9);
        if (res != null) {
            for (List<Integer> li : res) {
                for (int i : li)
                    System.out.print(i + " ");
                System.out.println("_____________");
            }
        }
    }
}
