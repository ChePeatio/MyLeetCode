package com.chepeatio;

import com.chepeatio.combinationSum.CombinationSumIII;
import com.chepeatio.combinations.Combinations;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello, LeetCode!");
        Combinations test = new Combinations();
        List<List<Integer>> lli = test.combine(5, 2);
        for (List<Integer> li : lli) {
            for (int i : li) {
                System.out.print(i + " ");
            }
            System.out.println("--------");
        }
    }
}
