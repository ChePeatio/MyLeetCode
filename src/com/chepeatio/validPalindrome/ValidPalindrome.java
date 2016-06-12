package com.chepeatio.validPalindrome;

/**
 * Created by Che Peatio on 2016/6/12.
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s==null || s.isEmpty())
            return true;
        char[] chs = s.toCharArray();
        int low = 0, high = chs.length-1;
        while (low < high) {
            while (low<=high && !Character.isLetterOrDigit(chs[low]))
                low++;
            while (low<=high && !Character.isLetterOrDigit(chs[high]))
                high--;
            if (low >= high)
                return true;
            else if (Character.toLowerCase(chs[low]) != Character.toLowerCase(chs[high]))
                return false;
            low++;
            high--;
        }
        return true;
    }

    /**
     * Slow solution by extracting alphanumeric characters and
     * comparing the string and the reversed string.
     * @param s string
     * @return whether valid palindrome
     */
    public boolean isPalindromeSlowSolution(String s) {
        if (s==null || s.isEmpty())
            return true;
        StringBuilder sb = new StringBuilder();
        char[] chs = s.toCharArray();
        for (char ch : chs) {
            if (Character.isLetter(ch)) {
                sb.append(Character.toLowerCase(ch));
            } else if (Character.isDigit(ch)) {
                sb.append(ch);
            }
        }
        String s1 = sb.toString();
        return s1.equals(sb.reverse().toString());
    }
}
