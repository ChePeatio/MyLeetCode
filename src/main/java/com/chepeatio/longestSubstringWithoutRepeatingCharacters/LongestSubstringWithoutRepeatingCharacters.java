package com.chepeatio.longestSubstringWithoutRepeatingCharacters;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Che Peatio on 2015/11/9.
 * Edited by Che Peatio on 2016/4/24.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        Queue<Character> qc = new LinkedList<>();
        int sLength = s.length();
        for (int i=0; i<sLength; i++) {
            char ch = s.charAt(i);
            if (qc.contains(ch)) {
                if (result < qc.size())
                    result = qc.size();
                while (qc.contains(ch)) {
                    qc.remove();
                }
            }
            qc.add(ch);
        }
        if (qc.size() > result)
            result = qc.size();
        return result;
    }

    /**
     * 整个算法就获取当前字符后判断当前长度内有没有一样的字符，没有则加入继续，有则从重复字符后起重新计算字符串长度
     * 数组类似hash的作用，方便查找上一次该字符所在的位置。
     * @param s is the string
     * @return length of longest substring
     */
    public int lengthOfLongestSubstringBS(String s) {
        int lastIndices[] = new int[256];
        for(int i = 0; i<256; i++){
            lastIndices[i] = -1;
        }

        char[] chArray = s.toCharArray();
        int strLen = chArray.length;
        int maxLen = 0;
        int curLen = 0;
        int start = 0;
        for(int i = 0; i<strLen; i++){
            char cur = chArray[i];
            if(lastIndices[cur]  < start){
                lastIndices[cur] = i;
                curLen++;
            }
            else{
                int lastIndex = lastIndices[cur];
                start = lastIndex+1;
                curLen = i-start+1;
                lastIndices[cur] = i;
            }

            if(curLen > maxLen){
                maxLen = curLen;
            }
        }

        return maxLen;
    }
}
