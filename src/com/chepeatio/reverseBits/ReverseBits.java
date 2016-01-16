package com.chepeatio.reverseBits;

/**
 * Created by Che Peatio on 2016/1/16.
 */
public class ReverseBits {
    public int reverseBits(int n) {
        int res = 0;
        int count = 0;
        while (count < 32) {
            res = res << 1;
            if ((n & 1) == 1) {
                res = res | 1;
            }
            n = n >>> 1;
            count++;
        }
        return res;
    }
}
