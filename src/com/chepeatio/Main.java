package com.chepeatio;

import com.chepeatio.combinationSum.CombinationSum;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello, LeetCode!");
        CombinationSum test = new CombinationSum();
        List<List<Integer>> lists = test.combinationSum(new int[]{2,3,6,7}, 7);
        System.out.println("lists' size is " + lists.size());
        for (List<Integer> list : lists) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
