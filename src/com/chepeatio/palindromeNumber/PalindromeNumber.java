package com.chepeatio.palindromeNumber;

/**
 * Created by Che Peatio on 2016/1/6.
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        int reverse = 0, temp = x;
        while (temp > 0) {
            reverse = reverse * 10 + temp % 10;
            temp /= 10;
        }
        return reverse == x;
    }

    /**
     * Bad efficient solution.
     * @param x target number
     * @return judgement of palindrome number
     */
    public boolean isPalindromeBES(int x) {
        if (x < 0)
            return false;
        String s = String.valueOf(x);
        int left = 0, right = s.length()-1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
