package com.chepeatio.stringToInteger;

/**
 * Created by Che Peatio on 2016/4/16.
 */
public class StringToInteger {

    /**
     * 参考 Java Integer源码完成的，源码写得确实漂亮，应该多学习。
     * 尤其是判断溢出的地方，由于负数的个数大于正数，因此全程使用负数判断，因此不需要分开讨论。
     * @param str string to be translated into integer.
     * @return integer of the string.
     */
    public int myAtoi(String str) {

        if (str == null) // 字符串为null的异常情况
            return 0;

        int result = 0; // 返回结果
        boolean negative = false; // 是否为负数
        int len = str.length(); // 字符串长度，所有用到函数调用的地方，都提前用变量存好，为了更好的效率
        int limit = -Integer.MAX_VALUE; // 不溢出的前提下的极限值，当前是正数的极限值（统一用负数表示，范围更大）
        int multmin; // 做乘法运算前非溢出的极限值（与limit有关，或者说与符号有关）
        int digit; // 当前位的值
        int index = 0; // string的下标

        if (len > 0) {

            // remove empty space in the string.
            while (str.charAt(index) == ' ' && index < len) {
                index++;
            }
            if (index >= len) // 全是空格字符的异常情况
                return 0;

            char firstChar = str.charAt(index);
            // 判断第一个字符是否为符号，并根据符号调整limit值
            if (firstChar < '0') {
                if (firstChar == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE;
                } else if (firstChar != '+') { // 不合理字符的异常情况
                    return 0;
                }
                if (index == len-1) { // 只有+/-，没有数字的异常情况
                    return 0;
                }
                index++;
            }

            // 计算integer值，并处理溢出等异常
            multmin = limit / 10;
            while (index < len) {
                digit = Character.digit(str.charAt(index++), 10);
                if (digit < 0) { // 字符不合理，将已有的值返回
                    break;
                }

                if (result < multmin) { // 由于在负数范围内计算，因此result<multmin，则result*10肯定会溢出
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                result *= 10;
                if (result < limit + digit) { // 由于在负数范围内计算，因此result-digit<limit，说明会溢出
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                result -= digit;
            }
        } else {
            return 0; // 字符长度为0的异常情况
        }
        return negative ? result : -result;
    }
}
