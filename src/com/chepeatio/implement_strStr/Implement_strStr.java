package com.chepeatio.implement_strStr;

/**
 * Created by Che Peatio on 2016/5/1.
 */
public class Implement_strStr {

    /**
     * 简单粗暴的解法，高效率应该使用KMS算法，稍后编写
     * @param haystack 被搜索字符串
     * @param needle 搜索字符串
     * @return 第一个匹配的位置或者-1
     */
    public int strStr(String haystack, String needle) {
        char[] hchs = haystack.toCharArray();
        char[] nchs = needle.toCharArray();
        for (int i=0; i<=hchs.length-nchs.length; i++) {
            boolean noFind = false;
            for (int j=0; j<nchs.length; j++) {
                if (hchs[i+j] != nchs[j]) {
                    noFind = true;
                    break;
                }
            }
            if (!noFind)
                return i;
        }
        return -1;
    }
}
