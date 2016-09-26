package com.chepeatio.longestSubstringWithoutRepeatingCharacters;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Che Peatio on 2015/11/9.
 * Edited by Che Peatio on 2015/11/10.
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
     * 并没有理解这种算法是如何做到的，但是可以知道用队列这种方式的效率还是很低的，需要再斟酌
     * @param s is the string
     * @return length of longest substring
     */
    public int lengthOfLongestSubstringBS(String s) {
        int lastIndices[] = new int[256];
        for(int i = 0; i<256; i++){
            lastIndices[i] = -1;
        }

        int maxLen = 0;
        int curLen = 0;
        int start = 0;
        for(int i = 0; i<s.length(); i++){
            char cur = s.charAt(i);
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
