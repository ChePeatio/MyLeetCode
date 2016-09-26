package com.chepeatio.wordSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Che Peatio on 2015/10/21.
 * Edited by Che Peatio on 2015/10/22.
 */
public class WordSearchII {

    /**
     * v0.3
     * 鉴于之前的效果不佳，更换解决思路，使用字典树来完成词的搜索工作
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {

        List<String> result = new ArrayList<>();

        if (board==null || words.length==0)
            return result;

        int row = board.length;
        int column = board[0].length;

        Trie wordsTree = new Trie();
        for (String word : words) {
            wordsTree.insert(word);
        }

        for (int x=0; x<row; x++) {
            for (int y=0; y<column; y++) {

                if (wordsTree.isEmpty()) {
                    return result;
                }

                String ch = String.valueOf(board[x][y]);
                if (wordsTree.search(ch)) {
                    result.add(ch);
                    wordsTree.deleteBranch(ch);
                }

                if (wordsTree.startsWith(ch)) {
                    Stack<String> alter = new Stack<>();
                    alter.push(x+"_"+y);
                    List<String> pos = new ArrayList<>();
                    StringBuilder sb = new StringBuilder();

                    while (!alter.empty()) {

                        if (!wordsTree.startsWith(sb.toString())) {
                            while (!alter.empty() && !pos.contains(alter.peek())) {
                                alter.pop();
                            }
                            if (pos.contains(alter.peek())) {
                                alter.pop();
                                pos.remove(pos.size()-1);
                                sb.deleteCharAt(sb.length()-1);
                                continue;
                            } else {
                                break;
                            }
                        }

                        boolean find = false;
                        String a_b = alter.peek();
                        int a = Integer.valueOf(a_b.split("_")[0]);
                        int b = Integer.valueOf(a_b.split("_")[1]);
                        pos.add(a_b);
                        sb.append(board[a][b]);

                        if (a-1>=0) {
                            String tempS = sb.toString() + board[a-1][b];
                            if (wordsTree.startsWith(tempS) && !pos.contains((a-1)+"_"+b)) {
                                if (wordsTree.search(tempS)) {
                                    result.add(tempS);
                                    wordsTree.deleteBranch(tempS);
                                }
                                alter.push((a-1)+"_"+b);
                                find = true;
                            }
                        }
                        if (a+1<row) {
                            String tempS = sb.toString() + board[a+1][b];
                            if (wordsTree.startsWith(tempS) && !pos.contains((a+1)+"_"+b)) {
                                if (wordsTree.search(tempS)) {
                                    result.add(tempS);
                                    wordsTree.deleteBranch(tempS);
                                }
                                alter.push((a+1)+"_"+b);
                                find = true;
                            }
                        }
                        if (b-1>=0) {
                            String tempS = sb.toString() + board[a][b-1];
                            if (wordsTree.startsWith(tempS) && !pos.contains(a+"_"+(b-1))) {
                                if (wordsTree.search(tempS)) {
                                    result.add(tempS);
                                    wordsTree.deleteBranch(tempS);
                                }
                                alter.push(a+"_"+(b-1));
                                find = true;
                            }
                        }
                        if (b+1<column) {
                            String tempS = sb.toString() + board[a][b+1];
                            if (wordsTree.startsWith(tempS) && !pos.contains(a+"_"+(b+1))) {
                                if (wordsTree.search(tempS)) {
                                    result.add(tempS);
                                    wordsTree.deleteBranch(tempS);
                                }
                                alter.push(a+"_"+(b+1));
                                find = true;
                            }
                        }

                        if (!find) {
                            while (!alter.empty() && pos.contains(alter.peek())) {
                                pos.remove(pos.size()-1);
                                sb.deleteCharAt(sb.length()-1);
                                alter.pop();
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * 找到毗邻的候选节点，将其压栈用于后续的寻找和回退
     * @param board 2D字母表
     * @param nextLetter word中待寻找的下一个字母
     * @param alter 搜索栈，用于前进和回退，在本函数中会被修改
     * @param pos 已用位置，在本函数中不会被修改，不包含初始栈顶元素
     * @return 如果找到后续节点，返回true，否则false
     */
    public boolean getAdjacentLetter(char[][] board, char nextLetter, Stack<String> alter, List<String> pos) {
        boolean find = false;
        int row = board.length;
        int column = board[0].length;
        String x_y = alter.peek();
        int x = Integer.valueOf(x_y.split("_")[0]);
        int y = Integer.valueOf(x_y.split("_")[1]);

        if (x-1>=0 && board[x-1][y]==nextLetter && !pos.contains((x-1)+"_"+y)) {
            alter.push((x-1)+"_"+y);
            find = true;
        }
        if (x+1<row && board[x+1][y]==nextLetter && !pos.contains((x+1)+"_"+y)) {
            alter.push((x+1)+"_"+y);
            find = true;
        }
        if (y-1>=0 && board[x][y-1]==nextLetter && !pos.contains(x+"_"+(y-1))) {
            alter.push(x+"_"+(y-1));
            find = true;
        }
        if (y+1<column && board[x][y+1]==nextLetter && !pos.contains(x+"_"+(y+1))) {
            alter.push(x+"_"+(y+1));
            find = true;
        }
        if (find) {
            pos.add(x_y);
        } else {
            alter.pop();
            while (!alter.empty() && pos.contains(alter.peek())) {
                pos.remove(pos.size()-1);
                alter.pop();
            }
        }
        return find;
    }

    /**
     * v0.2
     * 第二次提交版本，效率较高，但还是会超时
     * @param board
     * @param words
     * @return
     */
    public List<String> findWordsTLE2(char[][] board, String[] words) {

        if (board==null || words.length==0)
            return null;

        List<String> result = new ArrayList<>();
        int row = board.length;
        int column = board[0].length;

        for (String target : words) {
            Stack<String> alter = new Stack<>();
            boolean find = false;
            for (int x=0; x<row; x++) {
                for (int y=0; y<column; y++) {
                    if (board[x][y] == target.charAt(0)) {

                        if (target.length() == 1) {
                            find = true;
                            result.add(target);
                            break;
                        }

                        alter.push(x+"_"+y);
                        List<String> pos = new ArrayList<>();
                        boolean got;
                        while (!alter.empty()) {
                            got = getAdjacentLetter(board, target.charAt(pos.size()+1), alter, pos);
                            if (pos.size()+1==target.length() && got) {
                                result.add(target);
                                find = true;
                                break;
                            }
                        }
                    }

                    if (find)
                        break;
                }

                if (find)
                    break;
            }
        }
        return result;
    }

    /**
     * v0.1
     * 目前的测试均通过，但超时，应该是算法效率不高的原因
     * @param board
     * @param words
     * @return
     */
    public List<String> findWordsTLE(char[][] board, String[] words) {

        if (board==null || words.length==0)
            return null;

        List<String> result = new ArrayList<>();
        int row = board.length;
        int column = board[0].length;

        for (int order=0; order<words.length; order++) {
            String target = words[order]; // the target string
            Stack<String> alter = new Stack<>();
            for (int x=0; x<row; x++) {
                for (int y=0; y<column; y++) {
                    if (board[x][y] == target.charAt(0)) {
                        alter.push(x+"_"+y);
                    }
                }
            }

            if (!alter.empty() && target.length()==1) {
                result.add(target);
                continue;
            }

            List<String> pos = new ArrayList<>();
            boolean got;
            while (!alter.empty()) {
                got = getAdjacentLetter(board, target.charAt(pos.size()+1), alter, pos);
                if (pos.size()+1==target.length() && got) {
                    result.add(target);
                    break;
                }
            }
        }
        return result;
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

        // 判断字典树是否为空
        public boolean isEmpty() {
            for (int i=0; i<26; i++) {
                if (root.childNodes[i]!=null)
                    return false;
            }
            return true;
        }

        // 根据提供的字符串删除字典树中的单词
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

}

