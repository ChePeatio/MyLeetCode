package com.chepeatio.lengthOfLastWord;

/**
 * Created by Che Peatio on 2016/1/20.
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int res = 0;
        int pos = s.length() - 1;
        while (pos >= 0) {
            if (s.charAt(pos)==' ' && res!=0)
                break;
            else if (s.charAt(pos) != ' '){
                res++;
            }
            pos--;
        }
        return res;
    }
}
