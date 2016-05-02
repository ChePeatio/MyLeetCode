package com.chepeatio.implement_strStr;

/**
 * Created by Che Peatio on 2016/5/1.
 */
public class Implement_strStr {

    /**
     * �򵥴ֱ��Ľⷨ����Ч��Ӧ��ʹ��KMS�㷨���Ժ��д
     * @param haystack �������ַ���
     * @param needle �����ַ���
     * @return ��һ��ƥ���λ�û���-1
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
