package com.chepeatio.generateParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Che Peatio on 2015/11/24.
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n != 0)
            utilGen(res, "(", 1, 1, n);
        return res;
    }

    public void utilGen(List<String> al, String s, int cur, int diff, int n) {
        if (cur == n) {
            for (int i=0; i<diff; i++) {
                s += ")";
            }
            al.add(s);
            return;
        }
        for (int i=0; i<=diff; i++) {
            String temp = "";
            for (int num = 0; num < i; num++) {
                temp += ")";
            }
            utilGen(al, s+temp+"(", cur+1, diff+1-i, n);
        }
    }

    List<String> result = new ArrayList<>();
    public List<String> generateParenthesisBS(int n) {
        helper("",n,0);
        return result;
    }

    private void helper(String str, int left, int right){
        if(left == 0 && right == 0)
            result.add(str);
        if(left > 0){
            helper(str+"(", left-1,right+1);
        }
        if(right > 0){
            helper(str+")",left,right-1);
        }
    }
}
