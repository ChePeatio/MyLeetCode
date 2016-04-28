package com.chepeatio.threeSum;

import java.util.*;

/**
 * Created by Che Peatio on 2016/4/28.
 */
public class ThreeSum {

    /**
     * ��TwoSum��˼��Ӧ�õ�ThreeSum�ϣ���TwoSum��Sum��Ϊ��ֵ��ֻ��ҪO(n)�������ɣ�
     * ��ThreeSum��Sum��Ҫ��������Array�����ʵ���С�������Χ����ȷ����Sum�������ٴ�����TwoSum��˼�����
     * �����ʵ�����Թ��ظ���ϵ��뷨Ҳ��nice��ֵ�ý����
     * @param nums �����������ҷ�Χ��
     * @return һ�н������
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
     * ȷ�����ұ߽磬�ö��ֲ��ҵ�����ֵ����ʹ��Set��¼�Ѽ��������
     * Ч��Ӧ����O(n2logn)��ͨ��һЩ�Ż�tricks������ǿAC����ʱ����10%
     * @param nums ����Ѱ�ҷ�Χ
     * @return һ������
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
