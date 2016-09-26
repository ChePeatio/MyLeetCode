package com.chepeatio.pascalTriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Che Peatio on 2016/1/1.
 */
public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<=rowIndex; i++) {
            res.add(1);
        }
        for (int i=1; i<=rowIndex; i++) {
            for (int j=rowIndex-1; j>=i; j--) {
                res.set(j, res.get(j) + res.get(j+1));
            }
        }
        return res;
    }
}
