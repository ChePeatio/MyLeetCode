package com.chepeatio.romanToInteger;

/**
 * Created by Che Peatio on 2015/11/11.
 */
public class romanToInteger {
    public int romanToInt(String s) {
        int result = 0;
        int status = 0;

        for (char ch : s.toCharArray()) {
            switch (ch) {
                case 'I': result += 1;
                    status = 1;
                    break;
                case 'X': result += 10;
                    if (status == 1) {
                        result -= 2;
                        status = 0;
                    } else {
                        status = 10;
                    }
                    break;
                case 'C': result += 100;
                    if (status == 10) {
                        result -= 20;
                        status = 0;
                    } else {
                        status = 100;
                    }
                    break;
                case 'M': result += 1000;
                    if (status == 100) {
                        result -= 200;
                    }
                    status = 0;
                    break;
                case 'V': result += 5;
                    if (status == 1) {
                        result -= 2;
                    }
                    status = 0;
                    break;
                case 'L': result += 50;
                    if (status == 10) {
                        result -= 20;
                    }
                    status = 0;
                    break;
                case 'D': result += 500;
                    if (status == 100) {
                        result -= 200;
                    }
                    status = 0;
                    break;
                default: return -1;
            }
        }

        return  result;
    }
}
