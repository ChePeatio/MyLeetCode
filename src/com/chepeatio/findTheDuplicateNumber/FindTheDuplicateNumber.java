package com.chepeatio.findTheDuplicateNumber;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Che Peatio on 2015/11/16.
 */
public class FindTheDuplicateNumber {

    /**
     * 使用了弗洛伊德循环检测算法，但并不知道是什么鬼
     * @param nums 目标数组
     * @return 重复数值
     */
    public int findDuplicateBS(int[] nums) {
        int slow = 0;
        int fast = 0;
        int finder = 0;

        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast)
        {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        while (slow != finder)
        {
            slow = nums[slow];
            finder = nums[finder];
        }
        return slow;
    }

    /**
     * 二分查找的方法，将时间复杂度从n^2降到nlogn，会一定程度上提高效率
     * @param nums 目标数组
     * @return 重复的数字
     */
    public int findDuplicate(int[] nums) {
        int low = 1;
        int high = nums.length - 1;
        int medium;
        while (low <= high) {
            medium = (int)(low + (high - low) * 0.5);
            int count = 0;
            for (int num : nums) {
                if (num <= medium)
                    count++;
            }
            if (count <= medium)
                low = medium + 1;
            else
                high = medium - 1;
        }
        return low;
    }

    public int findDuplicateNS(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            } else {
                set.add(num);
            }
        }
        return -1;
    }
}
