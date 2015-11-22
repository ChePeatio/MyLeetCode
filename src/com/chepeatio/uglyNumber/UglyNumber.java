package com.chepeatio.uglyNumber;

/**
 * Created by Che Peatio on 2015/11/22.
 */
public class UglyNumber {
    public boolean isUgly(int num) {
        if (num <= 0)
            return false;
        int temp = num;
        while (temp % 2 == 0) {
            temp = temp >> 1;
        }
        while (temp % 3 == 0) {
            temp /= 3;
        }
        while (temp % 5 == 0) {
            temp /= 5;
        }
        return temp == 1;
    }
}
