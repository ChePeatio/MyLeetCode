package com.chepeatio.uniqueBinarySearchTrees;

/**
 * Created by Che Peatio on 2015/11/9.
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int sum = 0;
        int[] array = new int[n];
        for (int i=0; i<n; i++) {

        }
        return sum;
    }
    public int numTreesTLE(int n) {
        int sum = 0;
        if (n==0 || n==1) {
            return 1;
        }
        else {
            for (int i=0; i<n; i++) {
                sum += numTreesTLE(i) * numTreesTLE(n-1-i);
            }
            return sum;
        }
    }
}
