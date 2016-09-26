package com.chepeatio.happyNumber;

/**
 * Created by Che Peatio on 2015/11/12.
 */
public class HappyNumber {

    /**
     * 这道题直观的算法就是用Set来记录求解Happy Number时是否进入循环
     * 但Unhappy Number均会进入4/16/……这个循环，因此每次计算的结果判断与这些数是否一样即可
     * @param n 目标数字
     * @return 是否是happy number
     */
    public boolean isHappy(int n) {
        int sum = n;
        int temp;
        while (sum != 1) {
            temp = sum;
            sum = 0;
            while (temp != 0) {
                sum += (temp%10) * (temp%10);
                temp /= 10;
            }
            if (sum==4 || sum==16 || sum == 37 || sum == 42 || sum == 58 || sum == 89 || sum == 145)
                return false;
        }

        return true;
    }
}
