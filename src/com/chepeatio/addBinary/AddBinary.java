package com.chepeatio.addBinary;

/**
 * Created by Che Peatio on 2016/5/26.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        char[] cha = a.toCharArray();
        char[] chb = b.toCharArray();
        StringBuilder sb = new StringBuilder();

        int i = cha.length - 1;
        int j = chb.length - 1;
        int carry = 0;
        while (i>=0 || j>=0 || carry>0) {
            carry += i>=0 ? cha[i--] - '0' : 0;
            carry += j>=0 ? chb[j--] - '0' : 0;
            sb.append(carry & 1);
            carry = carry >> 1;
        }

        return sb.reverse().toString();
    }
}
