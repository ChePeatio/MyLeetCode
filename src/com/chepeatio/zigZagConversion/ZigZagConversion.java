package com.chepeatio.zigZagConversion;

/**
 * Created by Che Peatio on 2016/4/23.
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows < 2)
            return s;

        char[] chArray = s.toCharArray();
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i=0; i<numRows; i++) {
            sbs[i] = new StringBuilder();
        }
        int next = 1;
        int pos = 0;

        for (char aChArray : chArray) {
            sbs[pos].append(aChArray);
            if (pos == numRows - 1 && next == 1) {
                next = -1;
            } else if (pos == 0 && next == -1) {
                next = 1;
            }
            pos += next;
        }

        for (int i=1; i<numRows; i++) {
            sbs[0].append(sbs[i]);
        }
        return sbs[0].toString();
    }
}
