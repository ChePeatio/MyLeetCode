package com.chepeatio.groupAnagrams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Che Peatio on 2016/5/22.
 * Edited by Che Peatio on 2016/5/23.
 */
public class GroupAnagrams {

    /**
     * ʹ����������˻�ȷ����ĸ��ϣ�ʹ��HashMap�ҵ���ĸ��ϳ˻���List�Ĺ�ϵ��
     * ������Collections�ķ�����List�������򣬴Ӷ��õ������
     * ������HashMapʱ��ֻ��Ҫ����strs(����Ϊn)���䳤��l��ʱ�䳤��ΪO(nl)
     * �����ʱ�������򣬿�����ҪO(logn)��ʱ�䣬����ʱ��Ӧ��ΪO(nl)��Ӧ�����������Ч�ʡ�
     * @param strs �ַ�������
     * @return ��ͬ��ĸ��ϵ��ַ�������
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        int[] prime = new int[]{2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,
                59,61,67,71,73,79,83,89,97,101};
        HashMap<Long, List<String>> map = new HashMap<>();
        List<String> list;
        for (String str : strs) {
            char[] chs = str.toCharArray();
            long val = 1;
            for (char ch : chs) {
                val *= prime[ch-'a'];
            }
            if (map.containsKey(val)) {
                list = map.get(val);
            } else {
                list = new ArrayList<>();
                map.put(val, list);
            }
            list.add(str);
        }

        for (List<String> ls : map.values()) {
            Collections.sort(ls);
            res.add(ls);
        }

        return res;
    }
}
