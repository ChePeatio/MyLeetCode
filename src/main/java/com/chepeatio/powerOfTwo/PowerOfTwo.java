package com.chepeatio.powerOfTwo;

/**
 * Created by Che Peatio on 2015/11/27.
 */
public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if (n == 1) {
            return true;
        } else if (n<=0 || n%2==1) {
            return false;
        }

        int val = n;
        int guolv;
        while (val > 1) {
            guolv = val & 1;
            if (guolv == 1)
                return false;
            val >>= 1;
        }
        return true;
    }

    /**
     * 理解错题意而做的结果，实在是惭愧
     * @param n
     * @return
     */
    public boolean isSquare(int n) {
        int last = n % 10;
        if (last==2 || last==3 || last==7 || last==8)
            return false;

        int val = n;
        int i = 0;
        while (val > 0) {
            val -= i * 2 + 1;
            i++;
        }
        return val == 0;
    }
}
