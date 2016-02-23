package com.chepeatio.validParentheses;

import java.util.Stack;

/**
 * Created by Che Peatio on 2016/2/23.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (ch=='(' || ch=='[' || ch=='{')
                stack.push(ch);
            else if (ch==')') {
                if (stack.empty() || stack.pop()!='(')
                    return false;
            } else if (ch==']') {
                if (stack.empty() || stack.pop()!='[')
                    return false;
            } else {
                if (stack.empty() || stack.pop()!='{')
                    return false;
            }
        }
        return stack.empty();
    }
}
