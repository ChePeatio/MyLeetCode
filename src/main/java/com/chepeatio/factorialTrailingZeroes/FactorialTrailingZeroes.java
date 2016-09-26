package com.chepeatio.factorialTrailingZeroes;

/**
 * Created by Che Peatio on 2015/12/31.
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int res = 0;
        int temp = n / 5;
        while (temp > 0) {
            res += temp;
            temp /= 5;
        }
        return res;
    }
}
