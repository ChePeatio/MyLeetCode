package com.chepeatio.maximumProductOfWordLengths;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Che Peatio on 2016/1/9.
 */
public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        //ArrayList<Integer>[] all = new ArrayList[];
        Set<Character> set = new HashSet<>();
        int res = 0;
        int[] lengthWords = new int[words.length];
        for (int i=0; i<words.length; i++) {
            set.clear();
            lengthWords[i] = words[i].length();
            for (int j=0; j<lengthWords[i]; j++) {
                set.add(words[i].charAt(j));
            }
            Character[] list = (Character[])set.toArray();
            words[i] = String.valueOf(list);
        }
        for (int i=0; i<words.length-1; i++) {
            set.clear();
            int lengthI = words[i].length();
            for (int j=0; j<lengthI; j++) {
                set.add(words[i].charAt(j));
            }
            for (int j=i+1; j<words.length; j++) {
                int lengthJ = words[j].length();
                for (int k=0; k<lengthJ; k++) {
                    if (set.contains(words[j].charAt(k))) {
                        lengthJ = 0;
                    }
                }
                if (res < lengthWords[i] * lengthWords[j])
                    res = lengthWords[i] * lengthWords[j];
            }
        }
        return res;
    }
}
