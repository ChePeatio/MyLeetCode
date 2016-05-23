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
     * DFS version��ǰһ��û�ж�����������򣬻�����ظ�������������Ҫʹ�ö���Ŀռ���ȥ�أ�
     * ���㷨�������������������������ʣ������Թ��ظ�������Ӷ����ͱ�����ʱ�䣬
     * ͬʱÿ�θ��¶���ͬ��Ҳ�ͱ�֤��������ظ����������˲���Ҫ����Ŀռ��ʱ��ȷ����Ψһ�ԣ����ܺ����룬����97%�Ľⷨ
     * @param nums ��ȫ���е�����
     * @return ȫ�����з�ʽ
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
     * ���û��ݷ�������������ʹ�������������ɶ���ֵͬ�ĺ��ԣ��㷨Ч�ʺܵͣ������ҪѰ�ҷǱ����ķ������Ч�ʡ�
     * �����㷨�����������⣬��ʹ��StringBuilder�ж��ظ�����ʵ��sorted֮�����ﲢû���ظ�����Ϣ�����Բ���Ҫ��һ���֡�
     * @param nums ��ȫ���е�����
     * @return ȫ�����з�ʽ
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
