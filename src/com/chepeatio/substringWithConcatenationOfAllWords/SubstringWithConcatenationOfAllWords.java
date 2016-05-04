package com.chepeatio.substringWithConcatenationOfAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Che Peatio on 2016/5/2.
 * Edited by Che Peatio on 2016/5/4.
 */
public class SubstringWithConcatenationOfAllWords {

    /**
     * 字符串使用窗口来线性处理字符串匹配问题，效率巨大提升的关键点是它每次都不舍弃已放入HashMap中的数据，
     * 从而能够充分利用已有数据，完成快速匹配。记s的长度为l，words的个数为n，word的长度为wl，
     * 则时间复杂度为O(wl*l/wl)=O(l)，也即与s的长度呈线性关系，比TLE版本的时间复杂度降低不少
     * 另外，Hash结构的时间效率不是很低，比队列等其它结构效率要好很多。
     * @param s 源字符串
     * @param words 字符串序列
     * @return 起点下标
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s==null || s.length()==0 || words==null || words.length==0)
            return res;

        HashMap<String, Integer> cws = new HashMap<>();
        for (String word : words) {
            if (cws.containsKey(word))
                cws.put(word, cws.get(word)+1);
            else
                cws.put(word, 1);
        }

        int strLen = words[0].length();
        int start, count;
        String cur;
        HashMap<String, Integer> hm = new HashMap<>();

        for (int i=0; i<strLen; i++) {
            start = i;
            count = 0;
            hm.clear();
            for (int j=i; j<=s.length()-strLen; j+=strLen) {
                cur = s.substring(j, j+strLen);
                if (cws.containsKey(cur)) {
                    if (hm.containsKey(cur)) {
                        hm.put(cur, hm.get(cur)+1);
                    } else {
                        hm.put(cur, 1);
                    }

                    if (hm.get(cur) <= cws.get(cur)) {
                        count++;
                    } else {
                        while (hm.get(cur) > cws.get(cur)) {
                            String st = s.substring(start, start+strLen);
                            hm.put(st, hm.get(st)-1);
                            if (!cur.equals(st))
                                count--;
                            start += strLen;
                        }
                    }

                    if (count == words.length) {
                        res.add(start);
                        String st = s.substring(start, start+strLen);
                        hm.put(st, hm.get(st)-1);
                        count--;
                        start += strLen;
                    }
                } else {
                    start = j + strLen;
                    count = 0;
                    hm.clear();
                }
            }
        }

        return res;
    }

    /**
     * TLE版本，用HashMap来记录次数，从字符串开始遍历到最后一个可行节点，每次最多计算所有字符串的长度，
     * 记源字符串的长度为l，全部words的个数为n，长度为wl，则时间复杂度应该是O((l-n*wl)*n)也即O(l*n)
     * @param s 源字符串
     * @param words 字符串数组
     * @return 下标
     */
    public List<Integer> findSubstringTLE(String s, String[] words) {
        List<Integer> res = new ArrayList<>();

        if (s==null || s.length()==0 || words==null || words.length==0)
            return res;

        HashMap<String, Integer> countWords = new HashMap<>();
        for (String word : words) {
            if (countWords.containsKey(word))
                countWords.replace(word, countWords.get(word) + 1);
            else
                countWords.put(word, 1);
        }
        int strLen = words[0].length();
        int totalLen = strLen * words.length;
        int start = 0, index, count;
        String cur;
        HashMap<String, Integer> hm = new HashMap<>();


        while (start <= s.length() - totalLen) {
            index = start;
            count = 0;
            hm.clear();
            while (countWords.containsKey(cur = s.substring(index, index+strLen))) {
                if (hm.containsKey(cur)) {
                    hm.replace(cur, hm.get(cur) + 1);
                } else {
                    hm.put(cur, 1);
                }
                if (hm.get(cur) > countWords.get(cur))
                    break;
                if (++count == words.length) {
                    res.add(start);
                    break;
                }
                index += strLen;
            }
            start++;
        }

        return res;
    }
}
