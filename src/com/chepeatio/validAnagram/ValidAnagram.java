package com.chepeatio.validAnagram;

import java.util.Arrays;

/**
 * Created by Che Peatio on 2015/10/31.
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        char[] sCharArray = s.toCharArray();
        Arrays.sort(sCharArray);

        char[] tCharArray = t.toCharArray();
        Arrays.sort(tCharArray);
        return Arrays.equals(sCharArray, tCharArray);
    }

    public boolean isAnagramBS(String s, String t) {
        int sum = 0;
        int sProduct = 1;
        int tProduct = 1;
        for (char ch : s.toCharArray()) {
            sum += ch;
            sProduct *= ch;
        }
        for (char ch : t.toCharArray()) {
            sum -= ch;
            tProduct *= ch;
        }
        return sum==0 && sProduct==tProduct;
    }
}
