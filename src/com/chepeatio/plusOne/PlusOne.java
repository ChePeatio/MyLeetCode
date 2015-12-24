package com.chepeatio.plusOne;

/**
 * Created by Che Peatio on 2015/12/24.
 */
public class PlusOne {
    /**
     * The solution aims at the special condition and gives the special idea to solve
     * @param digits the bit list of the number
     * @return new bit list of the number
     */
    public int[] plusOne(int[] digits) {
        for (int i=digits.length-1; i>=0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
                if (i==0) {
                    int[] res = new int[digits.length+1];
                    res[0] = 1;
                    return res;
                }
            }
        }
        return digits;
    }
    public int[] plusOneSlowSolution(int[] digits) {
        int[] res;
        int len = 0;
        while (len < digits.length && digits[len] == 9) {
            len++;
        }
        if (len == digits.length) {
            res = new int[digits.length+1];
            res[0] = 1;
        } else {
            res = new int[digits.length];
            int temp = 1, val;
            for (int i=digits.length-1; i>=0; i--) {
                val = digits[i] + temp;
                res[i] = val > 9 ? val-10 : val;
                temp = val > 9 ? 1 : 0;
            }
        }
        return res;
    }
}
