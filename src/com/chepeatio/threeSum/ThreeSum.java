package com.chepeatio.threeSum;

import java.util.*;

/**
 * Created by Che Peatio on 2016/4/28.
 */
public class ThreeSum {

    /**
     * 将TwoSum的思想应用到ThreeSum上，在TwoSum中Sum作为定值，只需要O(n)遍历即可，
     * 而ThreeSum的Sum需要遍历整个Array（可适当减小其遍历范围），确定了Sum，即可再次利用TwoSum的思想求解
     * 另外该实现中略过重复组合的想法也很nice，值得借鉴。
     * @param nums 无序整数查找范围，
     * @return 一列结果数组
     */
    public List<List<Integer>> threeSumBestSolution(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i=0; i<nums.length-2&&nums[i]<=0; i++) {
            if (i==0 || nums[i]!=nums[i-1]) {
                int lo = i+1, hi = nums.length-1, sum = 0-nums[i];
                while (lo < hi) {
                    if (nums[lo]+nums[hi]==sum) {
                        res.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
                        while (lo < hi && nums[lo]==nums[lo+1])
                            lo++;
                        lo++;
                        while (lo < hi && nums[hi]==nums[hi-1])
                            hi--;
                        hi--;
                    } else if (nums[lo]+nums[hi]> sum) {
                        hi--;
                    } else {
                        lo++;
                    }
                }
            }
        }
        return res;
    }

    /**
     * 确定左右边界，用二分查找第三个值，并使用Set记录已加入的内容
     * 效率应该是O(n2logn)，通过一些优化tricks，能勉强AC，用时倒数10%
     * @param nums 整数寻找范围
     * @return 一列数列
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3)
            return res;

        Set<String> set = new HashSet<>();
        int val, x1, x2, x3;
        Arrays.sort(nums);
        for (x1=0; (x1<nums.length-2)&&(nums[x1]<=0); x1++) {
            for (x3=nums.length-1; (x3>x1+1)&&(nums[x3]>=0); x3--) {
                val = 0 - nums[x1] - nums[x3];
                if (val > nums[3])
                    break;
                x2 = findElement(nums, x1+1, x3-1, val);
                if (x2 != -1) {
                    String s = nums[x1] + " " + nums[x2] + " " + nums[x3];
                    if (!set.contains(s)) {
                        set.add(s);
                        res.add(Arrays.asList(nums[x1], nums[x2], nums[3]));
                    }
                }
            }
        }
        return res;
    }

    public int findElement(int[] nums, int left, int right, int val) {
        int pos;
        while (left <= right) {
            pos = (left + right) >> 1;
            if (nums[pos] == val)
                return pos;
            else if (nums[pos] < val) {
                left = pos+1;
            } else {
                right = pos-1;
            }
        }
        return -1;
    }
}
