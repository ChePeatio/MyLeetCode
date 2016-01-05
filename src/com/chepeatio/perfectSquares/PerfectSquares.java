package com.chepeatio.perfectSquares;

import java.util.ArrayList;

/**
 * Created by Che Peatio on 2016/1/5.
 */
public class PerfectSquares {
    static ArrayList<Integer> count = new ArrayList<>();
    /**
     * DP solution which I don't get though it by myself.
     * @param n target number
     * @return count of numbers
     */
    public int numSquares(int n) {
        if (count.size() == 0)
            count.add(0);
        int m = count.size(), squares, val;
        while (m <= n) {
            squares = Integer.MAX_VALUE;
            for (int i=1; i*i<=m; i++) {
                val = count.get(m-i*i) + 1;
                if (val < squares)
                    squares = val;
            }
            count.add(squares);
            m = count.size();
        }
        return count.get(n);
    }

    /**
     * The solution uses some number theory: https://leetcode.com/discuss/56982/o-sqrt-n-in-ruby-c-c
     * @param n target number
     * @return count of number
     */
    public int numSquaresBS(int n) {
        if (n <= 0)
            return 0;
        while (n % 4 == 0)
            n = n / 4;
        if (n % 8 == 7)
            return 4;
        for (int i = 0; i * i <= n; i++) {
            int j = (int) Math.sqrt(n - i * i);
            if (i * i + j * j == n) {
                if (i == 0 || j == 0)
                    return 1;
                else
                    return 2;
            }
        }
        return 3;
    }
}
