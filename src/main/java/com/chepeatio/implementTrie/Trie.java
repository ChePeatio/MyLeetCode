package com.chepeatio.implementTrie;

/**
 * Created by Che Peatio on 2015/10/22.
 */
public class Trie{
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {

        if (search(word))
            return;

        TrieNode temp = root;
        char[] charArrayWord = word.toCharArray();
        for (char nc : charArrayWord) {
            int pos = nc - 'a';
            if (temp.childNodes[pos] == null) {
                TrieNode ntn = new TrieNode(nc);
                temp.childNodes[pos] = ntn;
            }
            temp.childNodes[pos].numOfWords++;
            temp = temp.childNodes[pos];
        }
        temp.completeWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode temp = root;
        char[] charArrayWord = word.toCharArray();
        for (char cw : charArrayWord) {
            int pos = cw - 'a';
            if (temp.childNodes[pos] == null) {
                return false;
            } else {
                temp = temp.childNodes[pos];
            }
        }
        return temp.completeWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        char[] charArrayWord = prefix.toCharArray();
        for (char cw : charArrayWord) {
            int pos = cw - 'a';
            if (temp.childNodes[pos] == null) {
                return false;
            } else {
                temp = temp.childNodes[pos];
            }
        }
        return true;
    }

    // ÅÐ¶Ï×ÖµäÊ÷ÊÇ·ñÎª¿Õ
    public boolean isEmpty() {
        for (int i=0; i<26; i++) {
            if (root.childNodes[i]!=null)
                return false;
        }
        return true;
    }

    // ¸ù¾ÝÌá¹©µÄ×Ö·û´®É¾³ý×ÖµäÊ÷ÖÐµÄµ¥´Ê
    public void deleteBranch(String word) {
        if (!search(word))
            return;

        TrieNode temp = root;
        for (int i=0; i<word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            temp.childNodes[pos].numOfWords--;
            if (temp.childNodes[pos].numOfWords == 0) {
                temp.childNodes[pos] = null;
                break;
            } else {
                temp = temp.childNodes[pos];
                if (i == word.length()-1) {
                    temp.completeWord = false;
                }
            }
        }
    }
}