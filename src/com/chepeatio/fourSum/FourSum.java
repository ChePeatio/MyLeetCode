package com.chepeatio.fourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Che Peatio on 2016/4/30.
 */
public class FourSum {

    /**
     * 整体思路类3Sum，但考虑多种情况来优化遍历算法，AC时间超过90%
     * @param nums 待选择的整数
     * @param target 目标结果
     * @return 可选列表
     */
    public List<List<Integer>> fourSumLessTime(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4)
            return res;
        Arrays.sort(nums);
        int max = nums[nums.length-1];
        int min = nums[0];
        if (max<<2 < target || min<<2 > target)
            return res;

        int val, ac;
        for (int i=0; i<nums.length-3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])// avoid duplicate
                continue;
            if (nums[i] + 3 * max < target) // z is too small
                continue;
            if (4 * nums[i] > target) // z is too large
                break;
            if (4 * nums[i] == target) { // z is the boundary
                if (i + 3 < nums.length && nums[i + 3] == nums[i])
                    res.add(Arrays.asList(nums[i], nums[i], nums[i], nums[i]));
                break;
            }

            for (int j=i+1; j<nums.length-2; j++) {
                if (j==i+1 || nums[j]!=nums[j-1]) {
                    val = target - nums[i] - nums[j];
                    int low = j+1, high = nums.length-1;
                    while (low < high) {
                        ac = nums[low] + nums[high];
                        if (ac == val) {
                            res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                            while (low<high && nums[low]==nums[low+1])
                                low++;
                            low++;
                            while (low<high && nums[high]==nums[high-1])
                                high--;
                            high--;
                        } else if (ac < val) {
                            low++;
                        } else {
                            high--;
                        }
                    }
                }
            }
        }

        return res;
    }

    /**
     * 借鉴2Sum和3Sum完成的普通版4Sum，时间复杂度为O(n3)，效率一般
     * @param nums 待选择的整数
     * @param target 目标结果
     * @return 可选列表
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4)
            return res;

        Arrays.sort(nums);
        int val, ac;
        for (int i=0; i<nums.length-3; i++) {
            if (i==0 || nums[i]!=nums[i-1]) {
                for (int j=i+1; j<nums.length-2; j++) {
                    if (j==i+1 || nums[j]!=nums[j-1]) {
                        val = target - nums[i] - nums[j];
                        int low = j+1, high = nums.length-1;
                        while (low < high) {
                            ac = nums[low] + nums[high];
                            if (ac == val) {
                                res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                                while (low<high && nums[low]==nums[low+1])
                                    low++;
                                low++;
                                while (low<high && nums[high]==nums[high-1])
                                    high--;
                                high--;
                            } else if (ac < val) {
                                low++;
                            } else {
                                high--;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
