package com.chepeatio.n_Queens;

/**
 * Created by Che Peatio on 2015/11/6.
 */
public class N_Queens_II {
    public int totalNQueens(int n) {
        int[] result = new int[1];

        if (n == 0) {
            return result[0];
        }

        boolean[][] placeHolder = new boolean[n][n];
        placeQueen(placeHolder, n, result);
        return result[0];
    }

    public void placeQueen(boolean[][] ph, int seq, int[] result) {
        if (seq == 0) {
            result[0] += 1;
            return;
        }

        int level = ph.length - seq;
        for (int i=0; i<ph.length; i++) {
            if (!ph[level][i]) {
                boolean[][] placeHolder = new boolean[ph.length][ph.length];
                for (int l=level; l<ph.length; l++)
                    placeHolder[l] = ph[l].clone();
                for (int pos=0; pos<ph.length; pos++) {
                    placeHolder[level][pos] = true;
                    placeHolder[pos][i] = true;
                    int xIn = level + pos;
                    int yIn = i + pos;
                    int yDe = i - pos;
                    if (xIn<ph.length && yIn<ph.length)
                        placeHolder[xIn][yIn] = true;
                    if (xIn<ph.length && yDe>=0)
                        placeHolder[xIn][yDe] = true;
                }
                placeQueen(placeHolder, seq - 1, result);
            }
        }
    }
}
