package com.chepeatio.divideTwoIntegers;

/**
 * Created by Che Peatio on 2015/10/19.
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        int result = 0;

        if (divisor==0 || dividend==Integer.MIN_VALUE && divisor==-1) {
            return Integer.MAX_VALUE;
        } else if (dividend>=0 && divisor>0) {
            while (dividend > 0) {
                int newD = divisor;
                for (int i=0; dividend>=newD; newD<<=1, i++) {
                    if (dividend-newD < newD) {
                        result += 1<<i;
                        break;
                    }
                }
                dividend -= newD;
            }
        } else if (dividend>=0 && divisor<0) {
            while (dividend >= 0) {
                int newD = divisor;
                for (int i=0; dividend+newD>=0; newD<<=1, i++) {
                    if (dividend+newD <= -newD) {
                        result -= 1<<i;
                        break;
                    }
                }
                dividend += newD;
            }
        } else if (dividend<0 && divisor>0) {
            while (dividend <= 0) {
                int newD = divisor;
                for (int i=0; dividend+newD<=0; newD<<=1, i++) {
                    if (dividend+newD >= -newD) {
                        result -= 1<<i;
                        break;
                    }
                }
                dividend += newD;
            }
        } else {
            while (dividend <0) {
                int newD = divisor;
                for (int i=0; dividend<=newD; newD<<=1, i++) {
                    if (dividend-newD > newD) {
                        result += 1<<i;
                        break;
                    }
                }
                dividend -= newD;
            }
        }

        return result;
/*        if (dividend>0&&divisor<0 || dividend<0&&divisor>0) {
            return -result;
        } else {
            return result;
        }*/
    }

    public int divideBS(int dividend, int divisor) {
        return 0;
    }
}
