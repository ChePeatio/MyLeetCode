package com.chepeatio.excelSheetColumnNumber;

/**
 * Created by Che Peatio on 2015/10/30.
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int result = 0;
        for (int i=0; i<s.length(); i++) {
            result += (s.charAt(i) - '@') * Math.pow(26, s.length()-i-1);
        }
        return result;
    }
}
