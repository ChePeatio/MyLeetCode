package com.chepeatio.gameOfLife;

/**
 * Created by Che Peatio on 2015/12/21.
 */
public class GameOfLife {
    /**
     * multi-update will solve the problem in place.
     * first, generate multi-states, like 0 means d2d, 1 means l2l, 2 means l2d, 3 means d2l.
     * then, reduce the states to dead or live.
     * @param board
     */
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int[] dx = new int[]{-1,-1,-1,0,1,1,1,0};
        int[] dy = new int[]{-1,0,1,1,1,0,-1,-1};
        for (int x=0; x<m; x++) {
            for (int y=0; y<n; y++) {
                int cnt = 0;
                for (int i=0; i<8; i++) {
                    int posX = x + dx[i];
                    int posY = y + dy[i];
                    if (posX>=0 && posX<m && posY>=0 && posY<n && (board[posX][posY]==1 || board[posX][posY]==2)) {
                        cnt++;
                    }
                }
                if (board[x][y]==1 && (cnt<2 || cnt>3))
                    board[x][y] = 2;
                else if (board[x][y]==0 && cnt==3)
                    board[x][y] = 3;
            }
        }
        for (int x=0; x<m; x++) {
            for (int y=0; y<n; y++) {
                board[x][y] %= 2;
            }
        }
    }
}
