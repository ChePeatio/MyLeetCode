package com.chepeatio.pow_x_n;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Che Peatio on 2016/5/23.
 */
public class Pow_x_n {

    /**
     * 利用乘方加速计算，查看n中1的个数，同时需要注意n的符号
     * 本算法利用long解决了n的符号问题，利用右移解决了1的问题，利用每次必做的x*x完成了乘方的效果，效率极好
     * @param x double
     * @param n integer
     * @return double
     */
    public double myPowBeautiful(double x, int n) {
        double res = 1.0;
        long ln = Math.abs((long)n);
        for (; ln>0; ln=ln>>1, x*=x) {
            if ((ln & 1) == 1)
                res *= x;
        }
        return n<0 ? 1.0/res : res;
    }

    /**
     * 又一份丑极了的代码，效率肯定不忍直视
     * @param x double
     * @param n integer
     * @return double
     */
    public double myPow(double x, int n) {
        double res = 1.0;

        if (n == 0) {
            return res;
        } else if (n == Integer.MIN_VALUE) {
            res /= x;
            for (int i=0; i<32; i++)
                res = res * res;
            return res;
        }

        int sign = n < 0 ? -1 : 1;
        n = n < 0 ? -n : n;
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<31; i++) {
            if (((n>>i)&1) == 1) {
                list.add(i);
            }
        }

        double[] da = new double[1+list.get(list.size()-1)];
        da[0] = x;
        for (int i=1; i<da.length; i++) {
            da[i] = da[i-1] * da[i-1];
        }
        for (int pos : list) {
            res *= da[pos];
        }
        return sign==1 ? res : 1.0/res;
    }
}
