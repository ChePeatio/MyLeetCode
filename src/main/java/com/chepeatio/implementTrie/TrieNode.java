package com.chepeatio.implementTrie;

/**
 * Created by Che Peatio on 2015/10/22.
 */
class TrieNode {
    char nodeChar;
    boolean completeWord;
    int numOfWords;
    TrieNode[] childNodes;

    public TrieNode() {
        childNodes = new TrieNode[26];
    }

    public TrieNode(char nc) {
        childNodes = new TrieNode[26];
        nodeChar = nc;
    }
}
