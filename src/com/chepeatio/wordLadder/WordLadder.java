package com.chepeatio.wordLadder;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Che Peatio on 2015/11/12.
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        int result = 0;
        wordList.add(endWord);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        String[] array = wordList.toArray(new String[wordList.size()]);
        while (!queue.contains(endWord)) {
            while (!queue.isEmpty()) {
                String temp = queue.poll();
            }

            for (int i=0; i<array.length; i++) {
                for (int j=0; j<beginWord.length(); j++) {

                }
            }
            if (queue.size() == 0)
                return 0;
        }
        return array.length;
    }
}
