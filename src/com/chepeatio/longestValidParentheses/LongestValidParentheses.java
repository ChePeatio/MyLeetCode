package com.chepeatio.longestValidParentheses;


/**
 * Created by Che Peatio on 2016/5/4.
 * Edited by Che Peatio on 2016/5/6.
 */
public class LongestValidParentheses {

    /**
     * 第一次完成括号的Hard题目，使用栈（stack）记录当前所匹配过的括号，用valid和pos记录匹配的个数和位置，
     * 并根据位置确定与前面的括号是否连接，连接则合并，否则不合并；对于stack见底的情况，插入-1来隔断与前面的联系
     * 时间效率也不错
     * @param s 待匹配的括号字符串
     * @return 最长可匹配的字符串
     */
    public int longestValidParentheses(String s) {
        int res = 0;
        char[] chs = s.toCharArray();
        int stack = 0;
        int[] valid = new int[chs.length];
        int[] pos = new int[chs.length];
        int index = 0;

        for (char ch : chs) {
            if (ch == '(') {
                stack++;
            } else if (stack <= 0){
                stack = 0;
                valid[index] = -1;
                pos[index] = -1;
                index++;
            } else {
                stack--;
                valid[index] = 2;
                pos[index] = stack;

                while (index>0 && pos[index-1]>=stack) {
                    valid[index-1] += valid[index];
                    pos[index-1] = pos[index];
                    index--;
                }
                index++;
            }
        }

        for (int i=0; i<index; i++) {
            res = res < valid[i] ? valid[i] : res;
        }

        return res;
    }
}
