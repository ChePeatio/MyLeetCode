package com.chepeatio.wordLadder;

import java.util.*;

/**
 * Created by Che Peatio on 2015/11/12.
 * Edited by Che Peatio on 2016/04/20.
 */
public class WordLadder {

    /**
     * ʹ��Dijkstra�㷨��Ӧ���ǱȽ϶�·�ӵ��㷨����û�кú���⣬�����ٿ�������
     * Ҳ�����·�ӣ�Dijkstra�㷨��·��Ȩֵ����1���������Ȩֵ����1�������ø��Ӽ򵥵ķ��������
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLengthRS(String beginWord, String endWord, Set<String> wordList) {
        Set<String> reached = new HashSet<>();
        reached.add(beginWord);
        wordList.add(endWord);
        int distance = 1;
        while(!reached.contains(endWord)) {
            Set<String> toAdd = new HashSet<>();
            for(String each : reached) {
                for (int i = 0; i < each.length(); i++) {
                    char[] chars = each.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String word = new String(chars);
                        if(wordList.contains(word)) {
                            toAdd.add(word);
                            wordList.remove(word);
                        }
                    }
                }
            }
            distance ++;
            if(toAdd.size() == 0) return 0;
            reached = toAdd;
        }
        return distance;
    }

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
                for (String s : remove) {
                    wordListCopy.remove(s);
                }
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
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        int diff = 0;
        for (int i=0; i<len&&diff<2; i++) {
            if (ch1[i]!=ch2[i]) {
                diff++;
            }
        }
        return diff <= 1;
    }

    /**
     * ����Ŀ��˫��BFS�ⷨ�����ڲ���Ҫ���·������˽�������Set���ֱ��begin��end��ʼ����������ÿ�ζ����������ռ�С����һ��
     * �����ܹ������ܵ����Ч�ʣ���ֹһ������ʱ�Ŀռ�״̬Ѹ������
     * �������ж�������ĸ�Ƿ���wordList��ʱ�����㷨ʹ�����ȹ������жϵķ�ʽ����һ�ַ�ʽ������ȡwordList�е�Ԫ���жϡ�
     * �������飬���߻ᳬʱ����ǰ�ߵ�Ч�ʷǳ��ߣ�������Ϊ���ߵ��жϻ���ΪwordList���ȵ����Ӷ����ӣ���ǰ��ֻ��26����ĸ��أ���˱������ȶ���
     * �����ڽϴ�����ݼ��ϣ����߻���ֳ�ʱ��������������ַ��������ʱ��Ӧ��ѡ��ǰ�ߡ�
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int wordLadder(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        int len = 1;
        HashSet<String> visited = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> temp = new HashSet<>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();

                for (int i=0; i<chs.length; i++) {
                    for (char c='a'; c<='z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if (endSet.contains(target)) {
                            return len + 1;
                        }

                        if (!visited.contains(target) && wordList.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }
            beginSet = temp;
            len++;
        }
        return 0;
    }

    // ��֤isNeighbor����Ч�ʵĴ��룬��ʵ֤���Լ��ķ���Ч��̫low��
    public int wordLadder1(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();

        if (wordList.contains(beginWord))
            visited.add(beginWord);

        int len = 1;

        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> temp = new HashSet<>();
            for (String word : beginSet) {

                for (String other : endSet) {
                    if (isNeighbor(word,other))
                        return len + 1;
                }
                for (String other : wordList) {
                    if (!visited.contains(other) && isNeighbor(word, other)) {
                        temp.add(other);
                        visited.add(other);
                    }
                }
            }
            beginSet = temp;
            len++;
        }
        return 0;
    }
}
