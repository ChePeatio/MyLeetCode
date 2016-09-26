package com.chepeatio.grayCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Che Peatio on 2015/11/21.
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> al = new ArrayList<>();
        if (n == 1) {
            al.add(0);
            al.add(1);
        } else {
            List<Integer> temp = grayCode(n-1);
            al.addAll(temp);
            int len = temp.size();
            int high = (int)Math.pow(2, n-1);
            for (int i=0; i<len; i++) {
                al.add(high+temp.get(len-i-1));
            }
        }
        return al;
    }
}
