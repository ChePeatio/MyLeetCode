package com.chepeatio.rectangleArea;

/**
 * Created by Che Peatio on 2015/10/23.
 */
public class RectangleArea {
    public int computeAreaBS(int A, int B, int C, int D, int E, int F, int G, int H) {
        int common = (C<=E || A>=G || D<=F || B>=H) ? 0 : (Math.min(C,G)-Math.max(A,E)) * (Math.min(D,H)-Math.max(B,F));
        return (C-A) * (D-B) + (G-E) * (H-F) - common;
    }
}
