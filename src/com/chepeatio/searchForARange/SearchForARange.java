package com.chepeatio.searchForARange;

/**
 * Created by Che Peatio on 2016/5/8.
 */
public class SearchForARange {
    /**
     * 通过二分查找每个target的最小下标值，判断target是否存在，
     * 如果存在，继续查找target+1的位置，并判断该位置是否大于target（target是数列中最大值的情况）
     * 二分查找的效率是O(logn)，而其它地方不会增加算法的复杂度，所以算法时间复杂度为O(logn)，满足题意
     * @param nums 有序数列
     * @param target 目标值
     * @return 下标范围
     */
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = getIndex(nums, target);
        if (nums[res[0]] != target) {
            res[0] = -1;
            res[1] = -1;
        } else {
            res[1] = getIndex(nums, target+1);
            if (nums[res[1]] > target)
                res[1]--;
        }
        return res;
    }

    /**
     * 用二分查找法，找到target值的最小index
     * @param nums 有序查找序列
     * @param target 查找值
     * @return 最小index
     */
    private int getIndex(int[] nums, int target) {
        int left = 0, right = nums.length-1, medium;
        while (left < right) {
            medium = (left + right) >> 1;
            if (nums[medium] < target) {
                left = medium + 1;
            } else if (nums[medium] == target) {
                if (medium==0 || nums[medium-1]<target)
                    return medium;
                else
                    right = medium - 1;
            } else {
                right = medium;
            }
        }
        return left;
    }
}
