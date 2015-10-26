package com.chepeatio.wordSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Che Peatio on 2015/10/26.
 */
public class ReferAnswer {
    public List<String> findWords(char[][] board, String[] words) {

        List<String> result=new ArrayList<>();
        if (board==null || words.length==0)
            return result;

        int row = board.length;
        int column = board[0].length;

        Trie trie = new Trie();
        for (String word : words)
            trie.insert(word);

        boolean[][] visited=new boolean[row][column];

        for (int i = 0; i < row; i++)
            for (int j = 0; j < column; j++) {
                dfs(result, board, visited, "", i, j, trie, words);
                if (trie.isEmpty()) return result;
            }

        return result;
    }

    public void dfs(List<String> list,char[][] board, boolean[][] visited, String str, int x, int y, Trie trie, String[] words) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length)
            return;
        if (visited[x][y])
            return;
        str += board[x][y];
        if (!trie.startsWith(str))
            return;
        if (trie.search(str)) {
            list.add(str);
            trie.deleteBranch(str);
        }
        visited[x][y] = true;
        dfs(list,board, visited, str, x - 1, y, trie, words);
        dfs(list,board, visited, str, x + 1, y, trie, words);
        dfs(list,board, visited, str, x, y - 1, trie, words);
        dfs(list,board, visited, str, x, y + 1, trie, words);
        visited[x][y] = false;
    }
}

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

class Trie{
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

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

    public boolean isEmpty() {
        for (int i=0; i<26; i++) {
            if (root.childNodes[i]!=null)
                return false;
        }
        return true;
    }

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