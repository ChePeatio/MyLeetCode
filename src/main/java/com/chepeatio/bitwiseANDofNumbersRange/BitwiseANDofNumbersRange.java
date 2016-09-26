package com.chepeatio.bitwiseANDofNumbersRange;

/**
 * Created by Che Peatio on 2015/11/14.
 */
public class BitwiseANDofNumbersRange {

    /**
     * 抓住了求解的重点，因此效率很高
     * @param m 起始值
     * @param n 结束值
     * @return 返回AND运算的结果
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
     * 自己的解法，效率很低，需要进一步完善
     * @param m 起始值
     * @param n 结束值
     * @return 返回AND运算的结果
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
