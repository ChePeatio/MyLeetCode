package com.chepeatio;

import com.chepeatio.subsets.SubsetsII;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello, LeetCode!");
        SubsetsII test = new SubsetsII();
        List<List<Integer>> lists = test.subsetsWithDup(new int[]{1,2,2});
        for (List<Integer> list : lists) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
