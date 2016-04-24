package com.chepeatio.longestPalindromicSubstring;

/**
 * Created by Che Peatio on 2016/4/23.
 */
public class LongestPalindromicSubstring {

    /**
     * Ѱ���ַ���������Ĵ���Manacher�㷨����������˻��Ĵ��ԳƵ�˼�룬�������ظ�����
     * @param s input string
     * @return ��Ļ����ַ���
     */
    public String longestPalindromeWithManacher(String s) {
        char[] chArray = s.toCharArray();
        int len = chArray.length * 2 + 3;
        char[] nch = new char[len];
        nch[0] = '@';
        nch[len-1] = '$';
        for (int i=1; i<len-1; i++) {
            if ((i & 1) != 0) {
                nch[i] = '#';
            } else {
                nch[i] = chArray[(i>>1) - 1];
            }
        }
        int[] p = new int[len];

        int maxid = 0, center = 0, longest = 1, longestCenter = 0;
        for (int i=1; i<len-1; i++) {
            if (maxid > i) {
                p[i] = Math.min(p[2*center-i], maxid-i);
            } else {
                p[i] = 1;
            }
            while (nch[i-p[i]]==nch[i+p[i]]) {
                p[i]++;
            }
            if (p[i]+i > maxid) {
                maxid = p[i]+i;
                center = i;
            }
            if (longest < p[i]) {
                longest = p[i];
                longestCenter = center;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=longestCenter+1-longest; i<longestCenter+longest; i++) {
            if (nch[i] != '#')
                sb.append(nch[i]);
        }
        return sb.toString();
    }

    /**
     * �����ص��㷨��Ч��һ�㣬��ÿһ���㶼��Ҫ��������ĶԳ��ԣ��޷���Ч�������еĶԳƽ������Լ���Ч��
     * @param s input string
     * @return longest palindromic substring
     */
    public String longestPalindrome(String s) {
        char[] chArray = s.toCharArray();
        int len = chArray.length;
        if (len < 2)
            return s;

        String result = s.substring(0, 1);
        int minLength = 0;
        for (int i=0; i<len-1; i++) {
            if (chArray[i] == chArray[i+1]) {
                int j=0;
                while (i-j>=0 && i+1+j<len && chArray[i-j]==chArray[i+1+j]) {
                    j++;
                }
                if (minLength < j*2) {
                    minLength = j*2;
                    result = String.valueOf(chArray, i-j+1, minLength);
                }
            }
        }
        for (int i=1; i<len-1; i++) {
            if (chArray[i-1] == chArray[i+1]) {
                int j=1;
                while (i-j>=0 && i+j<len && chArray[i-j]==chArray[i+j]) {
                    j++;
                }
                j--;
                if (minLength < j*2+1) {
                    minLength = j*2+1;
                    result = String.valueOf(chArray, i-j, minLength);
                }
            }
        }
        return result;
    }
}
