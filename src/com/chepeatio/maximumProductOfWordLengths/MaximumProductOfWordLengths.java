package com.chepeatio.maximumProductOfWordLengths;

/**
 * Created by Che Peatio on 2016/1/9.
 * Edited by Che Peatio on 2016/1/10.
 */
public class MaximumProductOfWordLengths {

    /**
     * Using bits as flag, and using &| as operation can easily solve the problem of alphabets
     * @param words string list
     * @return maximum product of word lengths
     */
    public int maxProduct(String[] words) {
        int res = 0;
        int len = words.length;
        int[] mark = new int[len];
        int[] length = new int[len];
        for (int i=0; i<len; i++) {
            length[i] = words[i].length();
            for (int j=0; j<length[i]; j++) {
                int p = words[i].charAt(j) - 'a';
                p = 1 << p;
                mark[i] = mark[i] | p;
            }
        }
        for (int i=0; i<len; i++) {
            for (int j=i+1; j<len; j++) {
                if ((mark[i]&mark[j])==0) {
                    int val = length[i] * length[j];
                    res = res > val ? res : val;
                }
            }
        }
        return res;
    }

    /**
     * Naive solution, but well done.
     * @param words string list
     * @return maximum product of word lengths
     */
    public int maxProductLS(String[] words) {
        int res = 0;
        int[][] matrix = new int[26][words.length];
        int[][] values = new int[words.length][words.length];
        int[] lengthWords = new int[words.length];
        for (int i=0; i<words.length; i++) {
            lengthWords[i] = words[i].length();
            for (int j=0; j<lengthWords[i]; j++) {
                matrix[words[i].charAt(j)-'a'][i] = 1;
            }
        }
        for (int i=0; i<26; i++) {
            for (int j=0; j<words.length; j++) {
                if (matrix[i][j] == 1) {
                    for (int k=j+1; k<words.length; k++) {
                        if (matrix[i][k] == 1) {
                            values[j][k] = -1;
                        }
                    }
                }
            }
        }
        for (int i=0; i<words.length-1; i++) {
            for (int j=i+1; j<words.length; j++) {
                if (values[i][j] != -1) {
                    values[i][j] = lengthWords[i] * lengthWords[j];
                    res = res > values[i][j] ? res : values[i][j];
                }
            }
        }
        return res;
    }
}
