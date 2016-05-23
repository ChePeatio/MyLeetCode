package com.chepeatio.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Che Peatio on 2016/5/22.
 * Edited by Che Peatio on 2016/5/23.
 */
public class PermutationsII {

    /**
     * DFS version，前一版没有对数组进行排序，会出现重复的情况，因此需要使用额外的空间来去重；
     * 本算法对数组进行排序，利用有序的性质，可以略过重复情况，从而降低遍历的时间，
     * 同时每次更新都不同，也就保证不会出现重复的情况，因此不需要额外的空间和时间确保其唯一性，性能很理想，超过97%的解法
     * @param nums 待全排列的数组
     * @return 全部排列方式
     */
    public List<List<Integer>> permuteUniqueImprove(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums==null || nums.length==0)
            return res;

        boolean[] visited = new boolean[nums.length];
        Integer[] record = new Integer[nums.length];
        int[] sortNums = nums.clone();
        Arrays.sort(sortNums);
        process(res, visited, sortNums, 0, record);
        return res;
    }

    private void process(List<List<Integer>> res, boolean[] visited, int[] sortNums, int count, Integer[] record) {
        if (count == sortNums.length) {
            Integer[] val = record.clone();
            res.add(Arrays.asList(val));
        } else {
            int lastVisited = -1;
            for (int i=0; i<sortNums.length; i++) {
                if (!visited[i] && (lastVisited==-1 || sortNums[i]!=sortNums[lastVisited])) {
                    record[count] = sortNums[i];
                    visited[i] = true;
                    process(res, visited, sortNums, count+1, record);
                    visited[i] = false;
                    lastVisited = i;
                }
            }
        }
    }

    /**
     * 利用回溯法暴力排序，其中使用排序的数组完成对相同值的忽略，算法效率很低，因此需要寻找非暴力的方法提高效率。
     * 但该算法还有性能问题，即使用StringBuilder判断重复，其实在sorted之后，这里并没有重复的信息，所以不需要这一部分。
     * @param nums 待全排列的数组
     * @return 全部排列方式
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums==null || nums.length==0)
            return res;

        StringBuilder sb = new StringBuilder();
        HashSet<String> validOrder = new HashSet<>();
        boolean[] visited = new boolean[nums.length];
        int[] sortNums = nums.clone();
        Arrays.sort(sortNums);
        process(validOrder, visited, sortNums, 0, sb);
        for (String str : validOrder) {
            String[] tokens = str.split(" ");
            List<Integer> li = new ArrayList<>();
            for (String s : tokens) {
                li.add(Integer.parseInt(s));
            }
            res.add(li);
        }
        return res;
    }

    private void process(HashSet<String> validOrder, boolean[] visited, int[] sortNums, int count, StringBuilder sb) {
        if (count == sortNums.length) {
            validOrder.add(sb.toString());
        } else {
            int len = sb.length();
            int lastVisited = -1;
            for (int i=0; i<sortNums.length; i++) {
                if (!visited[i] && (lastVisited==-1 || sortNums[i]!=sortNums[lastVisited])) {
                    sb.append(sortNums[i]);
                    sb.append(" ");
                    count++;
                    visited[i] = true;
                    process(validOrder, visited, sortNums, count, sb);
                    visited[i] = false;
                    count--;
                    sb.delete(len, sb.length());
                    lastVisited = i;
                }
            }
        }
    }
}
