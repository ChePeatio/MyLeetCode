package com.chepeatio.uniqueBinarySearchTrees;

/**
 * Created by Che Peatio on 2015/11/9.
 */
public class UniqueBinarySearchTrees {
    /**
     * 在计算树的个数时，由于不需要关心子树的值，可以看成个数
     * 这样可以充分利用之前计算好的数据，提高效率。
     * @param n 个数
     * @return 树的个数
     */
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

    /**
     * 常规的递归做法，但是创建了太多的无意义数据，因此效率太低
     * @param n 个数
     * @return 树的个数
     */
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
