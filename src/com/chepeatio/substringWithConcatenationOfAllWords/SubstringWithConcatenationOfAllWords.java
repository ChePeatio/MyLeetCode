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
     * �ַ���ʹ�ô��������Դ����ַ���ƥ�����⣬Ч�ʾ޴������Ĺؼ�������ÿ�ζ��������ѷ���HashMap�е����ݣ�
     * �Ӷ��ܹ���������������ݣ���ɿ���ƥ�䡣��s�ĳ���Ϊl��words�ĸ���Ϊn��word�ĳ���Ϊwl��
     * ��ʱ�临�Ӷ�ΪO(wl*l/wl)=O(l)��Ҳ����s�ĳ��ȳ����Թ�ϵ����TLE�汾��ʱ�临�ӶȽ��Ͳ���
     * ���⣬Hash�ṹ��ʱ��Ч�ʲ��Ǻܵͣ��ȶ��е������ṹЧ��Ҫ�úܶࡣ
     * @param s Դ�ַ���
     * @param words �ַ�������
     * @return ����±�
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
     * TLE�汾����HashMap����¼���������ַ�����ʼ���������һ�����нڵ㣬ÿ�������������ַ����ĳ��ȣ�
     * ��Դ�ַ����ĳ���Ϊl��ȫ��words�ĸ���Ϊn������Ϊwl����ʱ�临�Ӷ�Ӧ����O((l-n*wl)*n)Ҳ��O(l*n)
     * @param s Դ�ַ���
     * @param words �ַ�������
     * @return �±�
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
