package com.chepeatio.sqrt_x;

/**
 * Created by Che Peatio on 2016/6/7.
 */
public class Sqrt_x {

    /**
     * This is a normal version. Since big numbers' multiply operation cost as much as small numbers,
     * we use bits to generate the result, which is faster than manual algorithm.
     * @param x integer value
     * @return sqrt of x
     */
    public int mySqrt(int x) {
        int result = 0;
        int cur = 1 << 15, pos = 14;
        long val;
        while (pos >= 0) {
            val = (long) cur * (long) cur;
            if (val < x) {
                result = cur;
                cur ^= 1 << pos;
            } else if (val == x) {
                return cur;
            } else {
                cur ^= 1 << (pos+1);
                cur ^= 1 << pos;
            }
            pos--;
        }
        val = cur * cur;
        if (val <= x)
            return cur;
        else
            return result;
    }
}
