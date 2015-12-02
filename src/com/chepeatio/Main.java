package com.chepeatio;

import com.chepeatio.permutations.Permutations;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello, LeetCode!");
        Permutations test = new Permutations();
        List<List<Integer>> res = test.permute(new int[]{1,2,3,4});
        for (List<Integer> re : res) {
            for (int val : re) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
