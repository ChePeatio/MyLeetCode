package com.chepeatio.addDigits;

/**
 * Created by Che Peatio on 2015/10/19.
 */
public class AddDigits {
    public int addDigits(int num) {
        int result = num;

        while(result > 9) {
            String number = result + "";
            result = 0;
            for (int i=0; i<number.length(); i++) {
                result += number.charAt(i) - '0';
            }
        }

        return result;
    }

    public int addDigitsBS(int num) {
        if (num == 0) {
            return num;
        } else {
            int x = num % 9;
            if (x == 0)
                return 9;
            else
                return x;
        }
    }
}
