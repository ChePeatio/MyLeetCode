package com.chepeatio.wordLadder;

import java.util.*;

/**
 * Created by Che Peatio on 2015/11/12.
 * Edited by Che Peatio on 2015/11/13.
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        int result = 1;
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int count;
        char oldCh;

        while (!queue.isEmpty()) {
            count = queue.size();

            for (int pos=0; pos<count; pos++) {
                char[] chs = queue.poll().toCharArray();
                for (int i=0; i<chs.length; i++) {
                    oldCh = chs[i];
                    for (char ch='a'; ch<='z'; ch++) {
                        if (ch == oldCh)
                            continue;
                        chs[i] = ch;

                        String cur = String.valueOf(chs);
                        if (!visited.contains(cur) && wordList.contains(cur)) {
                            queue.add(cur);
                            visited.add(cur);
                        }
                        if (endWord.equals(cur)) {
                            return result + 1;
                        }

                        chs[i] = oldCh;
                    }
                }
            }
            result++;
        }
        return 0;
    }

    public int ladderLengthTLE(String beginWord, String endWord, Set<String> wordList) {

        int result = 1;
        Set<String> wordListCopy = new HashSet<>();
        wordListCopy.addAll(wordList);
        wordListCopy.add(endWord);
        ArrayList<String> curAL = new ArrayList<>();
        curAL.add(beginWord);
        ArrayList<String> otherAL = new ArrayList<>();
        Set<String> remove = new HashSet<>();

        while (!curAL.contains(endWord)) {
            otherAL.clear();
            for (String temp : curAL) {
                for (String s : wordListCopy) {
                    if (isNeighbor(temp, s)) {
                        otherAL.add(s);
                        remove.add(s);
                    }
                }
                remove.forEach(wordListCopy::remove);
                remove.clear();
            }
            ArrayList<String> temp = curAL;
            curAL = otherAL;
            otherAL = temp;
            result++;
            if (curAL.size() == 0)
                return 0;
        }
        return result;
    }

    public boolean isNeighbor(String s1, String s2) {
        int len = s1.length();
        int diff = 0;
        for (int i=0; i<len; i++) {
            if (s1.charAt(i)!=s2.charAt(i)) {
                diff++;
                if (diff>1)
                    return false;
            }
        }
        return true;
    }
}
