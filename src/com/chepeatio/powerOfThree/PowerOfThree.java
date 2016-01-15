package com.chepeatio.powerOfThree;

/**
 * Created by Che Peatio on 2016/1/10.
 */
public class PowerOfThree {

    /**
     * A good solution for handling int32.
     * This solution is good at such problems.
     * @param n target number
     * @return is power of three
     */
    public boolean isPowerOfThree(int n) {
        return n>0 && (1162261467 % n)==0;
    }
}
