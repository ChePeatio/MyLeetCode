package com.chepeatio.climbingStairs;

/**
 * Created by Che Peatio on 2015/11/14.
 */
public class ClimbingStairs {
    /**
     * �����ʵ�ֺܼ򵥣���Ҫ���ܰ���Ŀ���Ϊ쳲��������У�������˵��
     * ����������n�㣬��ô���������n���أ�
     * ��Ϊÿ��ֻ����1��2������ô������n��ķ���Ҫô�Ǵӵ�n-1��һ�������ģ�
     * Ҫ�����Ǵ�n-2��2�������ģ����Ե��ƹ�ʽ�ǳ����׵ľ͵ó��ˣ�dp[n] = dp[n-1] + dp[n-2]��
     * @param n ¥�ݲ���
     * @return ��¥�ݵķ�ʽ
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
