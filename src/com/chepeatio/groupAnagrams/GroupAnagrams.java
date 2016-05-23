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
     * 使用质数及其乘积确定字母组合，使用HashMap找到字母组合乘积与List的关系。
     * 再利用Collections的方法对List进行排序，从而得到结果。
     * 在生成HashMap时，只需要遍历strs(个数为n)及其长度l，时间长度为O(nl)
     * 在输出时对其排序，可能需要O(logn)的时间，故总时间应该为O(nl)，应该算最理想的效率。
     * @param strs 字符串序列
     * @return 相同字母组合的字符串序列
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
