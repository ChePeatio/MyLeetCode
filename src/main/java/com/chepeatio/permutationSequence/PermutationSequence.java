package com.chepeatio.permutationSequence;

/**
 * Created by Che Peatio on 2016/5/24.
 * Edited by Che Peatio on 2016/5/26.
 */
public class PermutationSequence {
    /**
     * Recursive version which used / and % to decide which to be the next one,
     * and used char array to permute the sequence and system array copy to accelerate the movement.
     * @param n bigger than 1, and less than 10
     * @param k bigger than 0, and less than n!
     * @return permutation sequence
     */
    public String getPermutation(int n, int k) {
        String wrongRes = "";
        if (k<=0 || n>9)
            return wrongRes;

        int[] val = new int[n + 1];
        val[0] = 1;
        for (int i = 1; i <= n; i++) {
            val[i] = val[i - 1] * i;
        }
        if (k > val[n]) {
            return wrongRes;
        }

        char[] chs = new char[n];
        for (int i=0; i<n; i++) {
            chs[i] = (char)(i+'1');
        }

        getSwapPermutation(chs, 0, val, n-1, k-1);

        return String.valueOf(chs);
    }

    private void getSwapPermutation(char[] chs, int start, int[] val, int n, int k) {
        if (k != 0) {
            int index = k / val[n] + start;
            char temp = chs[index];
            System.arraycopy(chs, start, chs, start + 1, index - start);
            chs[start] = temp;
            getSwapPermutation(chs, start + 1, val, n - 1, k % val[n]);
        }
    }
}