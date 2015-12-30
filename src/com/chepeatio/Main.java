package com.chepeatio;

import com.chepeatio.differentWaysToAddParentheses.DifferentWaysToAddParentheses;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello, LeetCode!");
        DifferentWaysToAddParentheses test = new DifferentWaysToAddParentheses();
        for (int num : test.diffWaysToCompute("1-2*3+4")) {
            System.out.print(num + " ");
        }
    }
}
