package com.chepeatio.differentWaysToAddParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Che Peatio on 2015/12/30.
 */
public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> expression = getValues(input);
        return recursiveProcess(expression);
    }

    private List<Integer> recursiveProcess(List<Integer> list) {
        int length = list.size();
        List<Integer> res = new ArrayList<>();
        if (length == 1) {
            res.add(list.get(0));
        } else if (length == 3) {
            switch (list.get(1)) {
                case 1 : res.add(list.get(0) + list.get(2));
                    break;
                case 2 : res.add(list.get(0) - list.get(2));
                    break;
                case 3 : res.add(list.get(0) * list.get(2));
                    break;
                default : break;
            }
        } else {
            for (int i=1; i<length; i+=2) {
                List<Integer> left = recursiveProcess(list.subList(0,i));
                List<Integer> right = recursiveProcess(list.subList(i+1,length));
                for (int leftNum : left) {
                    for (int rightNum : right) {
                        switch (list.get(i)) {
                            case 1 : res.add(leftNum + rightNum);
                                break;
                            case 2 : res.add(leftNum - rightNum);
                                break;
                            case 3 : res.add(leftNum * rightNum);
                                break;
                            default: break;
                        }
                    }
                }
            }
        }
        return res;
    }

    /**
     * the structure of integer list is num,operator,num,operator,num,...
     * operator represent: 1 means +, 2 means -, 3 means *
     * @param input input string
     * @return the list defined by myself
     */
    private List<Integer> getValues(String input) {
        List<Integer> res = new ArrayList<>();
        int start = 0;
        for (int i=0; i<input.length(); i++) {
            if (input.charAt(i) == '+') {
                int val = Integer.valueOf(input.substring(start, i));
                res.add(val);
                res.add(1);
                start = ++i;
            } else if (input.charAt(i) == '-') {
                int val = Integer.valueOf(input.substring(start, i));
                res.add(val);
                res.add(2);
                start = ++i;
            } else if (input.charAt(i) == '*') {
                int val = Integer.valueOf(input.substring(start, i));
                res.add(val);
                res.add(3);
                start = ++i;
            }
        }
        int val = Integer.valueOf(input.substring(start, input.length()));
        res.add(val);
        return res;
    }
}
