package com.chepeatio.removeInvalidParentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Che Peatio on 2016/1/19.
 */
public class RemoveInvalidParentheses {

    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        remove(s, ans, 0, 0, new char[]{'(', ')'});
        return ans;
    }

    public void remove(String s, List<String> ans, int last_i, int last_j, char[] par) {
        int stack = 0, i;
        // Search for mismatch
        for (i = last_i; i < s.length(); ++i) {
            if (s.charAt(i) == par[0]) stack++;
            if (s.charAt(i) == par[1]) stack--;
            if (stack < 0) break;
        }
        // Remove a parenthesis
        if (stack < 0) {
            for (int j = last_j; j <= i; ++j) {
                if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1])) {
                    String candidate = s.substring(0, j) + s.substring(j + 1, s.length());
                    remove(candidate, ans, i, j, par);
                }
            }
            return;
        }
        // If no mismatch, try reverse the string
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(')
            remove(reversed, ans, 0, 0, new char[]{')', '('});
        else
            ans.add(reversed); // both sides are finished, got an answer
    }

    public List<String> removeInvalidParenthesesDFS(String s) {
        Set<String> res = new HashSet<>();
        int rmL = 0, rmR = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') rmL++; // rmL++指当前增加左括号等待配对，如果最终rmL不为0，说明它需要被去掉
            if(s.charAt(i) == ')') {
                if(rmL != 0) rmL--; // rmL--说明配对成功
                else rmR++; // rmR说明这里的右括号无法配对
            }
        }
        DFS(res, s, 0, rmL, rmR, 0, new StringBuilder());
        return new ArrayList<>(res);
    }

    public void DFS(Set<String> res, String s, int i, int rmL, int rmR, int open, StringBuilder sb) {
        if(i == s.length() && rmL == 0 && rmR == 0 && open == 0) {
            res.add(sb.toString());
            return;
        }
        if(i == s.length() || rmL < 0 || rmR < 0 || open < 0) return;

        char c = s.charAt(i);
        int len = sb.length();

        if(c == '(') {
            DFS(res, s, i + 1, rmL - 1, rmR, open, sb);
            DFS(res, s, i + 1, rmL, rmR, open + 1, sb.append(c));

        } else if(c == ')') {
            DFS(res, s, i + 1, rmL, rmR - 1, open, sb);
            DFS(res, s, i + 1, rmL, rmR, open - 1, sb.append(c));

        } else {
            DFS(res, s, i + 1, rmL, rmR, open, sb.append(c));
        }

        sb.setLength(len); // 回溯
    }
}
