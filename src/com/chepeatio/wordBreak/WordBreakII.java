package com.chepeatio.wordBreak;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Che Peatio on 2015/12/24.
 */
public class WordBreakII {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<>();
        int sLength = s.length();
        for (int i=0; i<sLength; i++) {
            String subString = s.substring(0, i);
            if (wordDict.contains(subString)) {
                String item = subString + " ";
                String tail = utilWordBreak(s.substring(i+1), wordDict);
                if (tail.equals("!")) {
                    res.add(item+tail);
                }
            }
        }
        return res;
    }

    private String utilWordBreak(String s, Set<String> wordDict) {
        return "";
    }
}
