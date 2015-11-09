package com.chepeatio.uniqueBinarySearchTrees;

/**
 * Created by Che Peatio on 2015/11/9.
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] array = new int[n+1];
        array[0] = 1;
        for (int cur=1; cur<n+1; cur++) {
            for (int i=0; i<cur; i++) {
                array[cur] += array[i] * array[cur-1-i];
            }
        }
        return array[n];
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
