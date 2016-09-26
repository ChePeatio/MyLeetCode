package com.chepeatio.climbingStairs;

/**
 * Created by Che Peatio on 2015/11/14.
 */
public class ClimbingStairs {
    /**
     * 这道题实现很简单，主要是能把题目理解为斐波那契数列，如下所说：
     * 假设梯子有n层，那么如何爬到第n层呢，
     * 因为每次只能怕1或2步，那么爬到第n层的方法要么是从第n-1层一步上来的，
     * 要不就是从n-2层2步上来的，所以递推公式非常容易的就得出了：dp[n] = dp[n-1] + dp[n-2]。
     * @param n 楼梯层数
     * @return 爬楼梯的方式
     */
    public int climbStairs(int n) {
        int[] cs = new int[n+1];
        cs[0] = 1;
        cs[1] = 1;
        for (int i=2; i<n+1; i++) {
            cs[i] = cs[i-1] + cs[i-2];
        }
        return cs[n];
    }
}
