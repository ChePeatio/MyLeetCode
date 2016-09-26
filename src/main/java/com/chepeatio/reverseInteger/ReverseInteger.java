package com.chepeatio.reverseInteger;

/**
 * Created by Che Peatio on 2016/1/16.
 */
public class ReverseInteger {
    public int reverse(int x) {
        int res = 0;
        // MAX_VALUE's head is 2, and overflow value's tail is 7, if num / 10 < bigOverflow, then num * 10 + 2 will be less than MAX_VALUE. So does to littleOverflow.
        int bigOverflow = Integer.MAX_VALUE / 10;
        int littleOverflow = Integer.MIN_VALUE / 10;
        while (x != 0) {
            if (res > bigOverflow || res < littleOverflow)
                return 0;
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }
}
