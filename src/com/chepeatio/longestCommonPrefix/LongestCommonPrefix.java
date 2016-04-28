package com.chepeatio.longestCommonPrefix;

/**
 * Created by Che Peatio on 2016/4/27.
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        else if (strs.length == 1)
            return strs[0];
        else {
            char[] ca = strs[0].toCharArray();
            int len = ca.length;
            for (int i=1; i<strs.length; i++) {
                char[] chs = strs[i].toCharArray();
                len = len < chs.length ? len : chs.length;
                for (int j=0; j<len; j++) {
                    if (ca[j] != chs[j]) {
                        len = j;
                        break;
                    }
                }
            }
            return strs[0].substring(0, len);
        }
    }

    public String longestCommonPrefixWrong(String[] strs) {
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];

        Trie root = new Trie();
        int result = 0;
        String str = "";
        int temp;
        for (String s : strs) {
            temp = root.insertCountLength(s);
            if (temp > result) {
                str = s;
                result = temp;
            }
        }
        return str.substring(0, result);
    }
}

class Trie {
    Trie[] child;
    int pass;

    public Trie() {
        pass = 0;
        child = new Trie[26];
    }

    public int insertCountLength(String s) {
        if (s == null)
            return 0;

        char[] chArray = s.toLowerCase().toCharArray();
        int len = chArray.length;
        if (len == 0) {
            return 0;
        }

        int count = 0;
        Trie temp = this;
        temp.pass++;
        for (char ch : chArray) {
            int pos = ch - 'a';
            if (temp.child[pos] == null) {
                Trie node = new Trie();
                node.pass = 1;
                temp.child[pos] = node;
                temp = node;
            } else {
                temp.child[pos].pass++;
                temp = temp.child[pos];
                count++;
            }
        }
        return count;
    }
}