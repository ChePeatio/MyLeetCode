package com.chepeatio.pow_x_n;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Che Peatio on 2016/5/23.
 */
public class Pow_x_n {

    /**
     * ���ó˷����ټ��㣬�鿴n��1�ĸ�����ͬʱ��Ҫע��n�ķ���
     * ���㷨����long�����n�ķ������⣬�������ƽ����1�����⣬����ÿ�α�����x*x����˳˷���Ч����Ч�ʼ���
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
     * ��һ�ݳ��˵Ĵ��룬Ч�ʿ϶�����ֱ��
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
