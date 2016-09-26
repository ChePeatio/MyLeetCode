package com.chepeatio.integerToRoman;

/**
 * Created by Che Peatio on 2015/11/13.
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int temp = num;
        while (temp >= 1000) {
            temp -= 1000;
            sb.append("M");
        }
        if (temp >= 900) {
            temp -= 900;
            sb.append("CM");
        } else if (temp >= 500) {
            temp -= 500;
            sb.append("D");
        } else if (temp >= 400) {
            temp -= 400;
            sb.append("CD");
        }
        while (temp >= 100) {
            temp -= 100;
            sb.append("C");
        }
        if (temp >= 90) {
            temp -= 90;
            sb.append("XC");
        } else if (temp >= 50) {
            temp -= 50;
            sb.append("L");
        } else if (temp >= 40) {
            temp -= 40;
            sb.append("XL");
        }
        while (temp >= 10) {
            temp -= 10;
            sb.append("X");
        }
        if (temp >= 9) {
            temp -= 9;
            sb.append("IX");
        } else if (temp >= 5) {
            temp -= 5;
            sb.append("V");
        } else if (temp >= 4) {
            temp -= 4;
            sb.append("IV");
        }
        while (temp > 0) {
            temp -= 1;
            sb.append("I");
        }
        return sb.toString();
    }

    /**
     * 机智的实现，对enum的利用,Easy Solution
     */
    public enum Type{
        M(1000),CM(900),D(500),CD(400),C(100),XC(90),L(50),XL(40),X(10),IX(9),V(5),IV(4),I(1);
        private final int value;
        Type(int value) {
            this.value = value;
        }
    };
    public String intToRomanES(int num) {
        StringBuilder output = new StringBuilder();
        for (Type t:Type.values()) {
            while (num>=t.value) {
                output.append(t);
                num -= t.value;
            }
        }
        return output.toString();
    }
}
