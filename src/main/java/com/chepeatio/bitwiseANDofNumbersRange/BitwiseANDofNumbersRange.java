package com.chepeatio.bitwiseANDofNumbersRange;

/**
 * Created by Che Peatio on 2015/11/14.
 */
public class BitwiseANDofNumbersRange {

    /**
     * ץס�������ص㣬���Ч�ʺܸ�
     * @param m ��ʼֵ
     * @param n ����ֵ
     * @return ����AND����Ľ��
     */
    public int rangeBitwiseAndBS(int m, int n) {
        int diffBits = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            diffBits++;
        }
        return n<<diffBits;
    }

    /**
     * �Լ��Ľⷨ��Ч�ʺܵͣ���Ҫ��һ������
     * @param m ��ʼֵ
     * @param n ����ֵ
     * @return ����AND����Ľ��
     */
    public int rangeBitwiseAnd(int m, int n) {
        int res;
        int diff = m ^ n;
        int count = 0;
        while (diff > 0) {
            diff = diff >> 1;
            count++;
        }
        int val = Integer.MAX_VALUE - (int)Math.pow(2, count) + 1;
        res = m & val;
        return res;
    }
}
