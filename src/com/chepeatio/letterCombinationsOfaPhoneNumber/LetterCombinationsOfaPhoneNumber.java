package com.chepeatio.letterCombinationsOfaPhoneNumber;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Che Peatio on 2016/4/30.
 */
public class LetterCombinationsOfaPhoneNumber {

    /**
     * FIFO队列，读取当前队列的内容，增加元素后再放入队列，以队列的长度为基准判断当前字符串处理完成与否
     * @param digits digits only digits without '*' or '#' or '1'
     * @return a list of string
     */
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        char[] chs = digits.toCharArray();
        if (chs.length == 0)
            return res;

        String[] mapping = new String[] {" ", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        for (int i=0; i<chs.length; i++) {
            int index = chs[i] - '0';
            while (res.peek().length()==i) {
                String s = res.remove();
                for (char c : mapping[index].toCharArray()) {
                    res.add(s+c);
                }
            }
        }
        return res;
    }

    /**
     * Recursive Solution
     * @param digits only digits without '*', '#' or '1'
     * @return a list of string
     */
    public List<String> letterCombinationsRecursiveSolution(String digits) {

        List<String> res = new ArrayList<>();
        char[] chs = digits.toCharArray();
        if (chs.length == 0)
            return res;

        char[][] nums = new char[10][];
        nums[0] = new char[1];
        nums[0][0] = ' ';
        nums[1] = new char[1];
        nums[1][0] = '`';
        nums[2] = new char[3];
        nums[2][0] = 'a';
        nums[2][1] = 'b';
        nums[2][2] = 'c';
        nums[3] = new char[3];
        nums[3][0] = 'd';
        nums[3][1] = 'e';
        nums[3][2] = 'f';
        nums[4] = new char[3];
        nums[4][0] = 'g';
        nums[4][1] = 'h';
        nums[4][2] = 'i';
        nums[5] = new char[3];
        nums[5][0] = 'j';
        nums[5][1] = 'k';
        nums[5][2] = 'l';
        nums[6] = new char[3];
        nums[6][0] = 'm';
        nums[6][1] = 'n';
        nums[6][2] = 'o';
        nums[7] = new char[4];
        nums[7][0] = 'p';
        nums[7][1] = 'q';
        nums[7][2] = 'r';
        nums[7][3] = 's';
        nums[8] = new char[3];
        nums[8][0] = 't';
        nums[8][1] = 'u';
        nums[8][2] = 'v';
        nums[9] = new char[4];
        nums[9][0] = 'w';
        nums[9][1] = 'x';
        nums[9][2] = 'y';
        nums[9][3] = 'z';

        List<String> lessResult = letterCombinations(String.valueOf(chs, 1, chs.length-1));
        for (char ch : nums[chs[0]-'0']) {
            StringBuilder sb = new StringBuilder();
            sb.append(ch);
            if (lessResult.size() == 0) {
                res.add(sb.toString());
            } else {
                for (String s : lessResult) {
                    sb.append(s);
                    res.add(sb.toString());
                    sb.delete(1, s.length() + 1);
                }
            }
        }
        return res;
    }
}
