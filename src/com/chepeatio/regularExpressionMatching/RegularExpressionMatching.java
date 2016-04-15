package com.chepeatio.regularExpressionMatching;

/**
 * Created by Che Peatio on 2016/4/15.
 */
public class RegularExpressionMatching {
    /**
     * Recursive solution without DFA or NFA
     * @param s string to be matched
     * @param p match pattern
     * @return whether can be matched
     */
    public boolean isMatch(String s, String p) {
        return tryMatch(s, p, 0, 0);
    }

    private boolean tryMatch(String s, String p, int si, int pi) {
        if (p.length() == pi) {
            return s.length() == si;
        }

        if (pi == p.length()-1 || p.charAt(pi+1) != '*') {
            return  matchChar(s, p, si, pi) && tryMatch(s, p, si+1, pi+1);
        } else {
            while (si<s.length() && (s.charAt(si) == p.charAt(pi)||p.charAt(pi)=='.')) {
                if (tryMatch(s, p, si, pi+2))
                    return true;
                si++;
            }
            return tryMatch(s, p, si, pi+2);
        }
    }

    private boolean matchChar(String s, String p, int si, int pi) {
        return pi < p.length() && si < s.length() && (p.charAt(pi) == s.charAt(si) || p.charAt(pi) == '.');
    }
}
