package com.chepeatio.pascalTriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Che Peatio on 2015/10/28.
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> temp = null;
        for (int level=0; level<numRows; level++) {
            if (level != 0)
                temp = result.get(level-1);
            List<Integer> layer = new ArrayList<>();
            for (int pos=0; pos<=level; pos++) {
                if (pos==0 || pos==level) {
                    layer.add(1);
                } else {
                    layer.add(temp.get(pos-1)+temp.get(pos));
                }
            }
            result.add(layer);
        }
        return result;
    }
}
