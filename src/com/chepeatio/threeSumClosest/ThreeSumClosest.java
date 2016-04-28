package com.chepeatio.threeSumClosest;

import java.util.Arrays;

/**
 * Created by Che Peatio on 2016/4/28.
 */
public class ThreeSumClosest {

    /**
     * ����3Sum�õ���һ���㷨������AC������Щ����Ӳ�ף�Ч�ʴ����70%����
     * @param nums �������ҷ�Χ
     * @param target Ŀ���
     * @return ������ӽ���ֵ
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int val, low, high;
        int res = nums[0] + nums[1] + nums[2] - target;

        for (int i=0; i<nums.length-2; i++) {
            if (i==0 || nums[i]!=nums[i-1]) {
                val = target - nums[i];
                low = i + 1;
                high = nums.length - 1;
                while (low < high) {
                    int nv = nums[low] + nums[high] - val;
                    if (nv > 0) {
                        while (high > low && nums[high]==nums[high-1]) {
                            high--;
                        }
                        high--;
                    } else if (nv < 0) {
                        while (high > low && nums[low]==nums[low+1]) {
                            low++;
                        }
                        low++;
                    } else {
                        return target;
                    }
                    if (Math.abs(nv) < Math.abs(res)) {
                        res = nv;
                    }
                }
            }
        }
        return res+target;
    }
}
