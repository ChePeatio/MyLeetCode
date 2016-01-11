package com.chepeatio.superUglyNumber;

/**
 * Created by Che Peatio on 2016/1/11.
 */
public class SuperUglyNumber {

    public int nthSuperUglyNumberOS(int n, int[] primes) {
        int size = primes.length;
        int q[] = new int[n];
        int idxes[] = new int[size];
        int vals[] = new int[size];
        q[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < size; j++) {
                vals[j] = q[idxes[j]] * primes[j];
            }
            q[i] = vals[0];
            for (int j = 1; j < size; j++) {
                if (q[i] > vals[j])
                    q[i] = vals[j];
            }
            for (int j = 0; j < size; j++) {
                if (vals[j] == q[i]) {
                    idxes[j] += 1;
                }
            }
        }
        return q[n - 1];
    }

    /** Here is my solution after I saw other's solution.
     * I thought multiply too many times would make the solution slow,
     * then I proposed my solution. However, I was wrong, and my solution is so ugly!!!
     * @param n
     * @param primes
     * @return
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1)
            return 1;
        int[] res = new int[n];
        res[0] = 1;
        res[1] = primes[0];
        for (int i = 2; i < n; i++) {
            res[i] = Integer.MAX_VALUE;
        }

        int[] indexs = new int[primes.length];
        indexs[0] = 1;

        int[] vals = new int[primes.length];
        System.arraycopy(primes, 0, vals, 0, primes.length);

        int[] changes = new int[primes.length];
        int scale = 1;

        for (int i = 2; i < n; i++) {
            for (int j=0; j<scale; j++) {
                vals[changes[j]] = res[indexs[changes[j]]] * primes[changes[j]];
            }

            for (int val : vals) {
                if (res[i] > val)
                    res[i] = val;
            }

            scale = 0;
            for (int j = 0; j < primes.length; j++) {
                if (res[i] == vals[j]) {
                    indexs[j] += 1;
                    changes[scale++] = j;
                }
            }
        }
        return res[n - 1];
    }
}
