package com.chepeatio;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello, LeetCode!");
        final int SC = 72;
        Random random = new Random(System.currentTimeMillis());
        int[] students = new int[SC];
        int count = 0, index;
        while (count < 36) {
            index = random.nextInt(72);
            if (students[index] == 0) {
                students[index] = 1;
                count++;
            }
        }
        System.out.print("First Group: ");
        for (int i=0; i<SC; i++) {
            if (students[i]==0)
                System.out.print(i + ", ");
        }
        System.out.println();
        System.out.print("Second Group: ");
        for (int i=0; i<SC; i++) {
            if (students[i]==1)
                System.out.print(i + ", ");
        }
        System.out.println();
    }
}
